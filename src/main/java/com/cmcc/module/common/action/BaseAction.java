package com.cmcc.module.common.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	private static final long serialVersionUID = 1L;
	public HttpServletRequest request;
    public ServletContext servletContext;
    public HttpServletResponse response;
	
	public String retMsg = "{flag:false,info:{retmsg:'操作失败,请与管理员联系!'}}";
	
	public void finish() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(retMsg);
			response.getWriter().flush();
	        response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public void setServletRequest(HttpServletRequest request) {
	     this.request = request;
	 }

	 public void setServletResponse(HttpServletResponse response) {
	     this.response = response;
	 }

	 public ServletContext getServletContext() {
	     return servletContext;
	 }

	 public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	 }
}
