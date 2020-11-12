package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Advaid Gireesan
 *
 */
public class ConnectionHandler {
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		/**
		 * 
		 */
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("Connection.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		final Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
					prop.getProperty("password"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return con;

	}
}
