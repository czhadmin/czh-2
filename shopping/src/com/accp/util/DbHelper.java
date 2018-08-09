package com.accp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/Goods";
	private static final String USER="root";
	private static final String PASSWORD="123";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
