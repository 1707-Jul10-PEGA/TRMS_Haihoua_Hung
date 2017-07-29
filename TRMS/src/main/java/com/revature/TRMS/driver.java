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
		d.run();
	}
	
	public void run() {
		
	}
}
