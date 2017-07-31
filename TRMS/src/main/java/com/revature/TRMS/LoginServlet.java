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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDaoImpl e_dao = new EmployeeDaoImpl();
		int login = -1;
		RequestDispatcher rd = null;
		try {
			login = e_dao.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(login >= 0) {
			session.setAttribute("username", username);
			session.setAttribute("userIDKey", login);
			response.getWriter().write("Success: " + session.getAttribute("username") + " (" + session.getAttribute("userIDKey") + ")");
			rd = request.getRequestDispatcher("mainmenu.html");
			rd.forward(request, response);
		}
		else {
			response.getWriter().write("loginFail");
			rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		
	}

}
