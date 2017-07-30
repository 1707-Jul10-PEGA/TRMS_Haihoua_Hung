package com.revature.TRMS;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import oracle.jdbc.driver.OracleDriver;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true;

	private ConnectionFactory() {

	}

	public static synchronized ConnectionFactory getInstance() {

		if (build) {

			cf = new ConnectionFactory();

		}

		return cf;

	}

	public Connection getConnection() {

		Connection conn = null;

		Properties prop = new Properties();

		try {
			prop.load(new FileReader("C:\\Users\\hy150\\Desktop\\Revature\\workspace\\TRMS\\src\\main\\resources\\datasource.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
	//		Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@trms.ciui1pa8mwjh.us-east-1.rds.amazonaws.com:1521:ORCL", 
					"user1234",
					"pass1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

}