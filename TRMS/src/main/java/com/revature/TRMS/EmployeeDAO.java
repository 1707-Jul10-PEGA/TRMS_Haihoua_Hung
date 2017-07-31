package com.revature.TRMS;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	Employee getEmployee(int id) throws SQLException;
	
	int saveEmployee(Employee e) throws SQLException;
	
	void updateEmployee(Employee fc) throws SQLException;
	
	List<Employee> getAllEmployee() throws SQLException;
	
	int deleteEmployee(int ids) throws SQLException;
	
	int login(String username, String password) throws SQLException;
}
