package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	
public static final String URL = "jdbc:mysql://localhost:3306/laptopmarketplace";
	
	public static final String USER_NAME = "root";
	
	public static Connection con;
	
	public static Connection createConnection() {
		
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection(URL, USER_NAME, "Shaurya135790");
		}
		catch(Exception e) {
			
			System.out.println("Something went wrong" + e);
		}
		
		return con;
		
		
	}

}
