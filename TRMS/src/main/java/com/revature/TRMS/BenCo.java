package com.revature.TRMS;

import java.sql.SQLException;

public class BenCo extends Employee{
	private int status = 3;
	public BenCo(int iD, String firstName, String lastName, String username, String password,
			String title, int supervisor, String department) {
		super(iD, firstName, lastName, username, password,title,supervisor,department);
	}
	
	public int adjustAmount(Request r, double amount) {
		//TODO: notify employee if larger, give reason if amount higher
		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			return r_dao.updateAmount(r.getRequestId(), amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



}
