package com.revature.TRMS;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class approveDenyServlet
 */
public class approveDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approveDenyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		int id = Integer.parseInt(session.getAttribute("userIDKey").toString());
		response.getWriter().write("Success: " + session.getAttribute("username") + " (" + session.getAttribute("userIDKey") + " | " + Integer.parseInt(request.getParameter("request")) +")");

		int request_id = Integer.parseInt(request.getParameter("request"));
		String action = request.getParameter("action");
		EmployeeDaoImpl e_dao = new EmployeeDaoImpl();
		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			Employee employee = e_dao.getEmployee(id);
			Request req = r_dao.getRequest(request_id);
			if(action.equalsIgnoreCase("approve")) {
				employee.approve(req);
			}
			else if(action.equalsIgnoreCase("deny")) {
				employee.deny(req);
			}
			else {
				
				response.getWriter().write("No action Taken");
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
