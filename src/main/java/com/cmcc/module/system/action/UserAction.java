package com.cmcc.module.system.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cmcc.module.system.bean.UserBean;
import com.cmcc.module.system.dao.TestJDBC;

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
		
		UserBean user = null;
		if (userid != null && userid != "" && password != null && password != "") {
			user = new TestJDBC().getUser(userid, password);
		}

		if (user != null) {
			retMsg = "{\"flag\": \"success\", \"info\": {\"user_name\": \""+user.getUser_name()+"\"}}";
		} else {
			retMsg = "{\"flag\": \"fail\"}";
		}
		finish();
	}

}
