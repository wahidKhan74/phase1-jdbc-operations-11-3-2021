package com.simplilearn.jdbcapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.operations.DatabaseConnection;

public class ProductDAO {

	Connection conn = null;
	Statement stm = null;
	ResultSet rst = null;
	PreparedStatement pstm = null;

	// list products
	public void getProducts() {
		try {
			conn = DatabaseConnection.initConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery("select * from eproducts");
			displayRecords(rst);

		} catch (Exception e) {
			System.out.println("Read operation failed !");
		}
	}

	// create product
	public void addProduct(String name, double price) {
		try {
			conn = DatabaseConnection.initConnection();
			String insertQuery = "insert into eproducts(name,price) values (?,?)";
			pstm = conn.prepareStatement(insertQuery);
			// set parameters
			pstm.setString(1, name);
			pstm.setDouble(2, price);
			// execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("Record Createed Successfully & No of rows affected ! " + rowsAffected);
		} catch (SQLException e) {
			System.out.println("Insertion operation failed !");
		}
	}
	
	// update product
	public void updateProduct(String name, double price, int id) {
		try {
			conn = DatabaseConnection.initConnection();
			String selectQuery = "update eproducts set name=? , price=? where pid=?";
			pstm = conn.prepareStatement(selectQuery);

			// set parameters
			pstm.setString(1, name);
			pstm.setDouble(2, price);
			pstm.setInt(3, id);

			// execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("No of rows updated ! " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Update operation failed !");
			e.printStackTrace();
		}
	}
	
	// get one product
	public void getProduct(int id) {
		try {
			conn = DatabaseConnection.initConnection();
			String selectQuery = "select * from eproducts where pid=?";
			pstm = conn.prepareStatement(selectQuery);

			// set parameters
			pstm.setInt(1, id);

			// execute query
			ResultSet rst = pstm.executeQuery();
			displayRecords(rst);
			
		} catch (SQLException e) {
			System.out.println("Read operation failed !");
			e.printStackTrace();
		}
	}
	
	// delete product
	public void deleteProduct(int id) {
		try {
			conn = DatabaseConnection.initConnection();
			String deleteQuery = "delete from eproducts where pid=?";
			pstm = conn.prepareStatement(deleteQuery);

			// set parameter
			pstm.setInt(1, id);
			// execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("No of rows deleted ! " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Delete operation failed !");
			e.printStackTrace();
		}
	}

	// display -> print
	public static void displayRecords(ResultSet rst) throws SQLException {
		while (rst.next()) {
			System.out.println("--------------");
			System.out.println(rst.getInt("pid") + ") " + rst.getString("name") + " - " + rst.getDouble("price")
					+ "  -  " + rst.getDate("create_date") + " - " + rst.getDate("expire_date"));
		}
	}

}

// WAP for CRUD operations customer and orders tables.
