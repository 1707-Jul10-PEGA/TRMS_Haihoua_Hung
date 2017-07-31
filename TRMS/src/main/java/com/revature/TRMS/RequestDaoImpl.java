package com.revature.TRMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

	public RequestDaoImpl(){
		// TODO Auto-generated constructor stub
	}
	
	public List<Request> getRequestWithStatus(int status){
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from REQUEST where status = " + status;
		Statement s;
		List<Request> requests = new ArrayList<Request>();
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				//TODO Loop Through ALL
				requests.add(new Request(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getTimestamp(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return requests;
	}

	@Override
	public Request getRequest(int id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from REQUEST where Request_ID = \'" + id + "\'";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			//TODO Get some info
			return new Request(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getTimestamp(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11),rs.getInt(12));
		}
		
		return null;//TODO CREATE USER WITH INFO// TODO Auto-generated method stub
	}

	@Override
	public int saveRequest(Request r) throws SQLException {
		//TODO
		//set the request_id in the employee table first before saving request
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into REQUEST values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, r.getRequestId());
		pstmt.setString(2, r.getFirstName());
		pstmt.setString(3, r.getLastName());
		pstmt.setDouble(4, r.getAmount());
		pstmt.setTimestamp(5, r.getEventDate());
		pstmt.setString(6, r.getLocation());
		pstmt.setString(7, r.getDescription());
		pstmt.setString(8, r.getGradingFormat());
		pstmt.setString(9, r.getEventType());
		pstmt.setString(10, r.getJustification());
		pstmt.setInt(11, r.getStatus());
		pstmt.setInt(12, r.getEmployeeID());
		return pstmt.executeUpdate();
	}

	@Override
	public void updateRequest(Request r) throws SQLException {
		// TODO Auto-generated method stub
		saveRequest(r);
		
	}

	@Override
	public List<Request> getAllRequest() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from REQUEST";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		List<Request> requests = new ArrayList<Request>();
		while(rs.next()) {
			//TODO Loop Through ALL
			requests.add(new Request(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getTimestamp(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11),rs.getInt(12)));
		}
		return requests;
	}

	@Override
	public int deleteRequest(int... ids) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "Delete from Request where REQUESTid = " +ids;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	@Override
	public void setEmployeeRequest(int E_ID, int R_ID) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "{call set_Employee_RequestID(" + E_ID + "," + R_ID + ")}";
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateStatus(int requestID, int newStatus) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "Update Request set status = " + newStatus + " where REQUEST_ID = \'" +requestID +"\'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	@Override
	public int updateAmount(int requestID, double newAmount) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "Update Request set amount = " + newAmount + " where REQUEST_ID = \'" +requestID +"\'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

}
