package com.revature.TRMS;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

public class driver {
	static Logger Log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		driver d = new driver();
	}
	
	public void run(Request r) {
		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			r_dao.saveRequest(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
