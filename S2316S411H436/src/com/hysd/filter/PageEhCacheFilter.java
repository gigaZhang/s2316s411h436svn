package com.hysd.filter;

import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.constructs.blocking.LockTimeoutException;
import net.sf.ehcache.constructs.web.AlreadyCommittedException;
import net.sf.ehcache.constructs.web.AlreadyGzippedException;
import net.sf.ehcache.constructs.web.filter.FilterNonReentrantException;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 服务端页面缓存过滤器：<br>
 * 利用服务端缓存机制，使那些访问频繁的动态页面可以直接快速响应给客户端，降低数据库等资源的访问压力。<br>
 * 参考地址：http://www.cnblogs.com/hoojo/archive/2012/07/12/2587556.html
 */
public class PageEhCacheFilter extends SimplePageCachingFilter {

	private final static Logger log = Logger.getLogger(PageEhCacheFilter.class);

	private final static String FILTER_URL_PATTERNS = "patterns";
	// 全局缓存策略
	private static String[] cacheURLs = null;

	/**
	 * 初始化
	 */
	private void init() throws CacheException {
		String patterns = filterConfig.getInitParameter(FILTER_URL_PATTERNS);
		if (patterns != null) {
			cacheURLs = StringUtils.split(patterns.trim(), ",");
		}
	}

	@Override
	protected void doFilter(final HttpServletRequest request,
			final HttpServletResponse response, final FilterChain chain)
			throws AlreadyGzippedException, AlreadyCommittedException,
			FilterNonReentrantException, LockTimeoutException, Exception {
		if (cacheURLs == null) {
			init();
		}

		String url = request.getRequestURI();

		// 临时缓存策略标志：若为true则启用服务端缓存，若为false则禁用服务端缓存。默认值为false
		boolean flag = false;
		// 临时缓存策略：可以临时改变“全局缓存策略”
		String pscy = request.getParameter("SCY");// 提交参数：如果提交参数中包含有SCY参数，则启用服务端缓存
		Object ascy = request.getAttribute("SCY");// Attr参数：如果Attr参数中包含有SCY参数，则启用服务端缓存
		String pscn = request.getParameter("SCN");// 提交参数：如果提交参数中包含有SCN参数，则禁用服务端缓存
		Object ascn = request.getAttribute("SCN");// Attr参数：如果Attr参数中包含有SCN参数，则禁用服务端缓存
		if (pscy != null || ascy != null) {
			flag = true;// 临时启用服务端缓存
		}
		if (pscn != null || ascn != null) {
			flag = false;// 临时禁用服务端缓存
		}

		if (pscy == null && ascy == null && pscn == null && ascn == null) {
			// 全局缓存策略：判断是否匹配配置的缓存URL规则
			if (cacheURLs != null && cacheURLs.length > 0) {
				for (String cacheURL : cacheURLs) {
					if (url.contains(cacheURL.trim())) {
						flag = true;
						break;
					}
				}
			}
		}

		if (true == flag) {// 启用服务端缓存：缓存当前请求页面
			String query = request.getQueryString();
			if (query != null) {
				if (url.indexOf("?") != -1) {
					query = "&" + query;
				} else {
					query = "?" + query;
				}
			}
			log.info("当前请求在服务端被缓存：" + url + query);
			super.doFilter(request, response, chain);// 调用Ehcache进行服务端缓存
		} else {// 禁用服务端缓存
			chain.doFilter(request, response);
		}

	}

	/**
	 * 兼容ie6/7的gzip压缩
	 * 
	 * @see net.sf.ehcache.constructs.web.filter.Filter#acceptsGzipEncoding(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected boolean acceptsGzipEncoding(HttpServletRequest request) {
		boolean ie6 = this.headerContains(request, "User-Agent", "MSIE 6.0");// 判断是否为IE6
		boolean ie7 = this.headerContains(request, "User-Agent", "MSIE 7.0");// 判断是否为IE7
		return this.acceptsEncoding(request, "gzip") || ie6 || ie7;
	}

	private boolean headerContains(final HttpServletRequest request,
			final String header, final String value) {
		this.logRequestHeaders(request);
		final Enumeration<String> accepted = request.getHeaders(header);
		while (accepted.hasMoreElements()) {
			final String headerValue = (String) accepted.nextElement();
			if (headerValue.indexOf(value) != -1) {
				return true;
			}
		}
		return false;
	}

}