package com.simplilearn.jdbcapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.jdbcapp.operations.DatabaseConnection;

public class DatabaseDAO {

	Connection conn = null;
	Statement stm = null;
	ResultSet rst = null;

	// create databases
	public void addDB(String dbName) {
		try {
			conn = DatabaseConnection.initConnection();
			String createQuery = "create database " + dbName;
			stm = conn.createStatement();
			stm.executeUpdate(createQuery);
			System.out.println("DB Createed Successfully ");
		} catch (SQLException e) {
			System.out.println("DB Create operation failed !");
		}
	}

	// drop databases
	public void dropDB(String dbName) {
		try {
			conn = DatabaseConnection.initConnection();
			String createQuery = "drop database " + dbName;
			stm = conn.createStatement();
			stm.executeUpdate(createQuery);
			System.out.println("DB Drop Successfully ");
		} catch (SQLException e) {
			System.out.println("DB drop operation failed !");
		}
	}
}
