package com.simplilearn.jdbcapp.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadOneProduct {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// create connection
			conn = DatabaseConnection.initConnection();
			// create prepare statement
			String selectQuery = "select * from eproducts where pid=?";
			pstm = conn.prepareStatement(selectQuery);

			// set parameters
			pstm.setInt(1, 6);

			// execute query
			ResultSet rst = pstm.executeQuery();

			while (rst.next()) {
				System.out.println("--------------");
				System.out.println(rst.getInt("pid") + ") " + rst.getString("name") + " - " + rst.getDouble("price")
						+ "  -  " + rst.getDate("create_date") + " - " + rst.getDate("expire_date"));
			}
			
		} catch (SQLException e) {
			System.out.println("Read operation failed !");
			e.printStackTrace();
		}

	}

}
