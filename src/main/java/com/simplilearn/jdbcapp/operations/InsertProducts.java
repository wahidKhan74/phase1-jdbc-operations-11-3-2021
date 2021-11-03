package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertProducts {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stm = null;
		
		try {
			// create connection
			conn = DatabaseConnection.initConnection();

			// create a statement
			stm = conn.createStatement();

			// execute query
			String query = "insert into eproducts(name,price) values ('One plus Nord 5G',6745.45)";
			int rowAffected = stm.executeUpdate(query);
			
			System.out.println(" No of rows affected ! "+rowAffected);

		} catch (Exception e) {
			System.out.println("Insertion operation failed !");
		}

	}

}
