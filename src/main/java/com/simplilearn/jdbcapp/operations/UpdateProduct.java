package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateProduct {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// create connection
			conn = DatabaseConnection.initConnection();
			// create prepare statement
			String selectQuery = "update eproducts set name=? , price=? where pid=?";
			pstm = conn.prepareStatement(selectQuery);

			// set parameters
			pstm.setString(1, "Apple- Iphone 11 max");
			pstm.setDouble(2, 13333.33);
			pstm.setInt(3, 6);

			// execute query
			// execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("No of rows updated ! " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Update operation failed !");
			e.printStackTrace();
		}

	}

}
