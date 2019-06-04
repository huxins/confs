package com.lanou3g;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCUtil {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static {
		InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			System.out.println(properties.getProperty("driverClass"));
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driverClass);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {		
		return DriverManager.getConnection(url,user,password);
	}
	public static void closeAll(ResultSet resultSet,Statement statement,Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭失败");
			}
			resultSet = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭失败");
			}
		}			
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭失败");
			}
		}	
	}
}
