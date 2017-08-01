package com.revature.TRMS;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int employeeID = Integer.parseInt(request.getParameter("e_id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.getWriter().write("User: " + fname + " " + lname + " " + employeeID + " " + username + " " + password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int employeeID = Integer.parseInt(request.getParameter("e_id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String title = request.getParameter("title");
		int supervisor = Integer.parseInt(request.getParameter("supervisor"));
		String department = request.getParameter("department");
		EmployeeDaoImpl e_dao = new EmployeeDaoImpl();
		try {
			e_dao.saveEmployee(new Employee(employeeID,fname,lname,username,password,title,supervisor,department));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
		
	}

}
