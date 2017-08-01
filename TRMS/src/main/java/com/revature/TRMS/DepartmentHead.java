package com.revature.TRMS;

public class DepartmentHead extends Employee{

	private int status = 2;
	public DepartmentHead(int iD, String firstName, String lastName, String username, String password,
			String title,int supervisor, String department) {
		super(iD, firstName, lastName, username, password,title,supervisor,department);
	}

}
