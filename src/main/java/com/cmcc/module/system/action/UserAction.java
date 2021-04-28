package com.cmcc.module.system.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class UserAction {

	public String retMsg;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public void finish() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(retMsg);
	}

	public void login() throws IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		if ("admin".equalsIgnoreCase(userid) && "admin".equalsIgnoreCase(password)) {
			retMsg = "success";
		} else {
			retMsg = "fail";
		}
		finish();
	}

}
