package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertProductsWithParams {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstm= null;
		try {
			// create connection
			conn = DatabaseConnection.initConnection();
			// create prepare statement
			String insertQuery ="insert into eproducts(name,price) values (?,?)";
			pstm = conn.prepareStatement(insertQuery);
			
			// set parameters
			pstm.setString(1, "Iphone 11 max");
			pstm.setDouble(2,12093.34);
			
			// execute query
			int rowsAffected = pstm.executeUpdate();			
			System.out.println(" No of rows affected ! "+rowsAffected);
		} catch (SQLException e) {
			System.out.println("Insertion operation failed !");
		}

	}

}
