package com.revature.TRMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public class EmployeeDaoImpl implements EmployeeDAO {

	public Employee getEmployee(int id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from Employee where ID = " + id;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			//TODO Get some info
		}
		
		return null;//TODO CREATE USER WITH INFO
	}

	public int saveEmployee(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into EMPLOYEE values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, e.getID());
		pstmt.setString(2, e.getFirstName());
		pstmt.setString(3, e.getLastName());
		pstmt.setInt(4, e.getRequestID());
		pstmt.setString(5, e.getUsername());
		pstmt.setString(6, e.getPassword());
		pstmt.setString(7, e.getTitle());
		return pstmt.executeUpdate();
	}

	public void updateEmployee(Employee fc) throws SQLException {
		// TODO We could do a insert here but if we have trigger for id it will not work
		//so we will need to update by fields but how do we know what change? do we use loop to
		//check each field or pass in as argument what change? 
		saveEmployee(fc);
		
		
	}

	public List<Employee> getAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from Employee";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
	
		while(rs.next()) {
			//TODO Loop Through ALL
		}
		return null;
	}

	public int deleteEmployee(int... ids) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "Delete from EMPLOYEE where id = " +ids;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

}
