package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Advaid Gireesan
 *Used to establish connection with MYSQL database 
 */
public class ConnectionHandler {
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		FileInputStream fis = new FileInputStream("Connection.properties");
		Properties prop = new Properties();
		prop.load(fis);
		Class.forName(prop.getProperty("driver"));
		Connection con = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
				prop.getProperty("password"));

		return con;

	}
}
