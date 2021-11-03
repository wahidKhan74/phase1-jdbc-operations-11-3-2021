package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadProducts {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		
		try {
			// create connection
			conn = DatabaseConnection.initConnection();

			// create a statement
			stm = conn.createStatement();

			// execute query
			rst = stm.executeQuery("select * from eproducts");

			while (rst.next()) {
				System.out.println("--------------");
				System.out.println(rst.getInt("pid") + ") " + rst.getString("name") + " - " 
				+ rst.getDouble("price") +"  -  "+ rst.getDate("create_date") +" - "+ rst.getDate("expire_date"));
			}

		} catch (Exception e) {
			System.out.println("Read operation failed !");
		}

	}

}
