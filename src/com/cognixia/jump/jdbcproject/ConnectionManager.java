package com.cognixia.jump.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/employeeDB";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	private static void makeConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Could not connect to database");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Connection could not be closed");
				e.printStackTrace();
			}
		}
	}
	
}

