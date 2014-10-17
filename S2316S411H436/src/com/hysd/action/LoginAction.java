package com.hysd.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hysd.domain.Emp;
import com.hysd.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private EmpService empService;

	private String empname;
	private String password;

	public String login() {

		System.out.println("\n提交的请求参数如下：");
		System.out.println("empname：" + empname);
		System.out.println("password：" + password + "\n");

		int eid = 0;
		try {
			eid = Integer.parseInt(empname);
		} catch (Exception ex) {
		}

		Emp emp = empService.findEmpById(eid);// 为了测试结果，这里写死了
		if (emp != null) {
			System.out.println("\n根据主键ID查询记录：查到了，查询成功！");
			System.out.println(emp.toString() + "\n");

//			// 在Action中访问ServletAPI的两种方式（其实还有第三种，只是特别麻烦，不推荐使用）
//			// 方式一：间接方式，使用ActionContext类
//			ActionContext ac = ActionContext.getContext();// 获取ActionContext实例，静态方法
//			Object valueObj = ac.get("key");// 相当于HttpServletRequest实例request.getParameter("key");
//			Map<String, Object> paramsMap = ac.getParameters();// 相当于HttpServletRequest实例request.getParameterMap();
//			Map<String, Object> sessionMap = ac.getSession();// 相当于HttpSession实例session
//			Map<String, Object> applicationMap = ac.getApplication();// 相当于ServletContext实例application
//			ValueStack valueStack = ac.getValueStack();// 获取ActionContext的值栈对象
//			// 方法二：直接方式，使用ServletActionContext类（无法实例化，全是静态方法，继承自ActionContext类）
//			PageContext pageContext = ServletActionContext.getPageContext();
//			HttpServletRequest request = ServletActionContext.getRequest();
//			HttpServletResponse response = ServletActionContext.getResponse();
//			HttpSession session = ServletActionContext.getRequest().getSession();
//			ServletContext application = ServletActionContext.getServletContext();
//			ActionContext ac2 = ServletActionContext.getContext();// 获取ActionContext实例
//			ValueStack valueStack2 = ServletActionContext.getValueStack(request);// 获取ActionContext的值栈对象

			// 访问request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("empname", emp.getEname());

			// 注意：这里使用GsonBuilder来创建Gson实例：打印格式化、日期格式化
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();
			String empJson = gson.toJson(emp);
			System.out.println("\nEmp对象转化为JSON格式：");
			System.out.println(empJson + "\n");

			return SUCCESS;
		} else {
			System.out.println("\n根据主键ID查询记录：没查到，查询失败，记录不存在！\n");
			return "failure";
		}

	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}