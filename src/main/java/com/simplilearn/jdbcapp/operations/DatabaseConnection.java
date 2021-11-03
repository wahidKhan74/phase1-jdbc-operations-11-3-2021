package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	static final String URL = "jdbc:mysql://localhost:3306/ecomdb";
	static final String USERNAME ="root";
	static final String PASSWORD = "root";
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	
	public static Connection initConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connection Failed !");
		}
		return conn;
	}
}
