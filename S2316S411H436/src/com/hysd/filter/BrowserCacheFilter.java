package com.hysd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 客户端浏览器缓存过滤器：<br>
 * 用于配置是否启用客户端浏览器缓存
 */
public class BrowserCacheFilter implements Filter {

	private FilterConfig filterConfig;

	// 全局缓存策略：是否启用客户端浏览器缓存：false为禁用浏览器缓存，true为启用浏览器缓存
	private boolean usecache = false;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String tempFE = filterConfig.getInitParameter("usecache");
		if ("true".equals(tempFE)) {
			usecache = true;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		// 临时缓存策略标志：若为true则启用浏览器缓存，若为false则禁用浏览器缓存。默认值为false
		boolean flag = false;
		// 临时缓存策略：可以临时改变“全局缓存策略”
		String pbcy = request.getParameter("BCY");// 提交参数：如果提交参数中包含有BCY参数，则启用浏览器缓存
		Object abcy = request.getAttribute("BCY");// Attr参数：如果Attr参数中包含有BCY参数，则启用浏览器缓存
		String pbcn = request.getParameter("BCN");// 提交参数：如果提交参数中包含有BCN参数，则禁用浏览器缓存
		Object abcn = request.getAttribute("BCN");// Attr参数：如果Attr参数中包含有BCN参数，则禁用浏览器缓存
		if (pbcy != null || abcy != null) {
			flag = true;// 临时启用浏览器缓存
		}
		if (pbcn != null || abcn != null) {
			flag = false;// 临时禁用浏览器缓存
		}

		if (pbcy == null && abcy == null && pbcn == null && abcn == null) {
			// 全局缓存策略
			if (false == usecache) {
				((HttpServletResponse) response).setHeader("Cache-Control",
						"no-cache");
				((HttpServletResponse) response)
						.setHeader("Pragma", "no-cache");
				((HttpServletResponse) response).setDateHeader("Expires", -1);
			}
		} else {
			// 临时缓存策略
			if (false == flag) {
				((HttpServletResponse) response).setHeader("Cache-Control",
						"no-cache");
				((HttpServletResponse) response)
						.setHeader("Pragma", "no-cache");
				((HttpServletResponse) response).setDateHeader("Expires", -1);
			}
		}

		filterChain.doFilter(request, response);
	}

	public void destroy() {
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public boolean isClientCache() {
		return usecache;
	}

	public void setClientCache(boolean clientCache) {
		this.usecache = clientCache;
	}

}
