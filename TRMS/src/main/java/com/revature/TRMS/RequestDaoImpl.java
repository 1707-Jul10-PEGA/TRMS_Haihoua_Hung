package com.revature.TRMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

	public RequestDaoImpl(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public Request getRequest(int id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from REQUEST where RequestID = " + id;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			//TODO Get some info
			return new Request(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5), rs.getTime(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
		}
		
		return null;//TODO CREATE USER WITH INFO// TODO Auto-generated method stub
	}

	@Override
	public int saveRequest(Request r) throws SQLException {
		//TODO
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into REQUEST values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, r.getRequestId());
		pstmt.setString(2, r.getFirstName());
		pstmt.setString(3, r.getLastName());
		pstmt.setDouble(4, r.getAmount());
		pstmt.setDate(5, (Date) r.getEventDate());
		pstmt.setTime(6, (Time) r.getEventTime());
		pstmt.setString(7, r.getLocation());
		pstmt.setString(8, r.getDescription());
		pstmt.setString(9, r.getGradingFormat());
		pstmt.setString(10, r.getEventType());
		pstmt.setString(11, r.getJustification());
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
			requests.add(new Request(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5), rs.getTime(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
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

}
