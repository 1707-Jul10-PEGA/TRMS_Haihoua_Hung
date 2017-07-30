package com.revature.TRMS;

import java.sql.SQLException;
import java.util.List;

public interface RequestDao {
	void setEmployeeRequest(int E_ID, int R_ID);
	List<Request> getRequestWithStatus(int status);
	Request getRequest(int id) throws SQLException;
	
	int saveRequest(Request r) throws SQLException;
	
	void updateRequest(Request r) throws SQLException;
	
	List<Request> getAllRequest() throws SQLException;
	
	int deleteRequest(int ... ids) throws SQLException;
}
