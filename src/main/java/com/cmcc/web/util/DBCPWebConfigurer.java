package com.cmcc.web.util;

import javax.servlet.ServletContext;

import com.cmcc.common.dbcp.Paramters;
import com.cmcc.common.dbcp.PoolFactory;

public class DBCPWebConfigurer {
	public static void initDBCPContext(ServletContext sc) {
		try {
			Paramters para = new Paramters();
			para.setDrivers("oracle.jdbc.OracleDriver");
			para.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			para.setUserName("wnpm");
			para.setPassword("wnpm");
			para.setMaxActive(300);
			para.setMaxIdle(20);
			para.setMaxWait(30000);
			para.setLogAbandoned(true);
			para.setRemoveAbandoned(true);
			para.setRemoveAbandonedTimeout(100000);
			para.setValidationQuery("select 1 from dual");
			para.setTestOnBorrow(true);
			para.setTestWhileIdle(true);

			para.setTimeBetweenEvictionRunsMillis(0);
			para.setMinEvictableIdleTimeMillis(0);
			para.setPoolPreparedStatements(true);
			para.setMaxPoolPreparedStatementPerConnectionSize(20);

			PoolFactory.buildPool(para);
		} catch (Exception e) {
		}
	}
}
