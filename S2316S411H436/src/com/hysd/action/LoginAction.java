package com.hysd.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hysd.domain.Emp;
import com.hysd.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

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

			HttpServletRequest request = ServletActionContext.getRequest();// 在Struts2的Action中获取Servlet的原生API
			request.setAttribute("empname", emp.getEname());

			// 注意：这里使用GsonBuilder来创建Gson实例
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