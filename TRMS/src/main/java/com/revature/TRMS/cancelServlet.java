package com.revature.TRMS;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cancelServlet
 */
public class cancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id = Integer.parseInt(session.getAttribute("userIDKey").toString());
		String action = request.getParameter("action");
		int request_id = Integer.parseInt(request.getParameter("request").toString());

		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			if(action.equalsIgnoreCase("cancel request")) {
				r_dao.deleteRequest(request_id);
			}
			else {
				int grade = Integer.parseInt(request.getParameter("grade"));
				r_dao.updateGrade(request_id, grade);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = null;
		if(session.getAttribute("title").equals("Employee")){
			rd = request.getRequestDispatcher("mainmenu.html");
			}
		else if(session.getAttribute("title").equals("Direct Supervisor"))
		{
			rd = request.getRequestDispatcher("mainmenuds.html");
		}
		rd.forward(request, response);
		//RequestDispatcher rd = request.getRequestDispatcher("viewRequest");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
