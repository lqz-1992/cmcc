package com.cmcc.module.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmcc.module.system.bean.UserBean;

public class TestJDBC {
	public TestJDBC() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "wnpm",
				"wnpm");
	}

	public UserBean getUser(String userId, String password) {
		UserBean user = null;
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = getConnection();
			s = c.createStatement();
			String sql = "select user_id, user_name from sys_user where user_id = '"+userId+"' and password = '"+password+"' ";
			rs = s.executeQuery(sql);

			if (rs.next()) {
				user = new UserBean();
				String id = rs.getString(1);
				String name = rs.getString(2);
				user.setUser_id(id);
				user.setUser_name(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
}
