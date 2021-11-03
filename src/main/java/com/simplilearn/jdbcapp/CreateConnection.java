package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateConnection {

	public static void main(String[] args) throws SQLException {
		
		// step1 : data source config.
		String url = "jdbc:mysql://localhost:3306/ecomdb";
		String username ="root";
		String password = "root";
		
		Connection conn =null;
		Statement stm = null;
		ResultSet res = null;
		try {
			// step2 : Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step3 : Create a connection
			conn = DriverManager.getConnection(url, username, password);
			if(conn!=null) {
				System.out.println("Connection is created successfully !");
			}
			// step4 : Create a statement
			stm = conn.createStatement();
			
			// step5 : execute query
			res = stm.executeQuery("select * from eproducts");
			
			while (res.next()) {
				System.out.println("--------------");
				System.out.println(res.getInt(1) +" "+res.getString(2)+"  "+res.getDouble(3));
			};
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Connection Failed !");
		} catch (SQLException e) {
			System.out.println("Connection Failed !");
		} finally {
			// step6 : close connection. 
			conn.close();
		}
		
		

	}

}
