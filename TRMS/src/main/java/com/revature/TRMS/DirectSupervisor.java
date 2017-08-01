package com.revature.TRMS;

public class DirectSupervisor extends Employee {
	private int status = 1;
	public DirectSupervisor(int iD, String firstName, String lastName, String username, String password,
			String title, int supervisor, String department) {
		super(iD, firstName, lastName, username, password,title,supervisor,department);
		// TODO Auto-generated constructor stub
	}

}
