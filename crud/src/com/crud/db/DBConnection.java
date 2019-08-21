package com.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	// define db properties
	public static final String jdbcURL = "jdbc:mysql://localhost:3306/student";

	public static final String driver = "com.mysql.jdbc.Driver";

	public static final String username = "root";

	public static final String password = "";

	// reference variable to hold connection obj

	public static Connection conn = null;

	public static Connection openConnection() {
		// check connection
		if (conn != null) {
			return conn;
		} else {
			try {
				// Load the Driver
				Class.forName(driver);
				// Get connection
				conn = DriverManager.getConnection(jdbcURL, username, password);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// return connection
			return conn;
		}
	}

}
