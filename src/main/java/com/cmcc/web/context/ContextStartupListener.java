package com.cmcc.web.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cmcc.web.util.DBCPWebConfigurer;

public class ContextStartupListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		DBCPWebConfigurer.initDBCPContext(event.getServletContext());
	}
}
