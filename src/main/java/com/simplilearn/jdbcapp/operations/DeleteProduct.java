package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteProduct {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// create connection
			conn = DatabaseConnection.initConnection();
			// create prepare statement
			String deleteQuery = "delete from eproducts where pid=?";
			pstm = conn.prepareStatement(deleteQuery);

			// set parameter
			pstm.setInt(1, 6);

			// execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("No of rows deleted ! " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Delete operation failed !");
			e.printStackTrace();
		}

	}

}
