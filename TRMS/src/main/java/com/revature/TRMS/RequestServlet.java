package com.revature.TRMS;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write(request.getParameter("date"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int employeeID = Integer.parseInt(request.getParameter("e_id"));
		double amount = Double.parseDouble(request.getParameter("cost"));
		
		Timestamp eventDate = null;
		//2010-10-10T10:10 YYYY-MM-ddTHH:mm
        String dateInString = request.getParameter("date");
        String[] dates = dateInString.split("T");


        //java.sql.Date sqlDate =new java.sql.Date(new java.util.Date().getTime());
		response.getWriter().write("dateInString format" + dates[0] + " " + dates[1]);
		eventDate = Timestamp.valueOf(dates[0] + " " + dates[1] + ":00.0");

        
		String location = request.getParameter("location");
		String description = request.getParameter("descr");
		String gradingFormat = request.getParameter("grading");
		String eventType = request.getParameter("type");
		String justification = request.getParameter("justification");
		String path = null;
		int passing_grade = -1;
		if(gradingFormat.equalsIgnoreCase("other")) {
			passing_grade = Integer.parseInt(request.getParameter("grading_other"));
		}
		
		Request r = new Request(0, fname, lname, amount, eventDate,
				location, description, gradingFormat, eventType, justification, 1,employeeID,path,passing_grade);
		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			r_dao.saveRequest(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(r.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().write(request.getParameter("date"));
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				int employeeID = Integer.parseInt(request.getParameter("e_id"));
				double amount = Double.parseDouble(request.getParameter("cost"));
				
				Timestamp eventDate = null;
				//2010-10-10T10:10 YYYY-MM-ddTHH:mm
		        String dateInString = request.getParameter("date");
		        String[] dates = dateInString.split("T");


		        //java.sql.Date sqlDate =new java.sql.Date(new java.util.Date().getTime());
				response.getWriter().write("dateInString format" + dates[0] + " " + dates[1]);
				eventDate = Timestamp.valueOf(dates[0] + " " + dates[1] + ":00.0");

		        
				String location = request.getParameter("location");
				String description = request.getParameter("descr");
				String gradingFormat = request.getParameter("grading");
				String eventType = request.getParameter("type");
				String justification = request.getParameter("justification");
				String path = null;
				int passing_grade = -1;
				if(gradingFormat.equalsIgnoreCase("3")) {
					passing_grade = Integer.parseInt(request.getParameter("grading_other"));
				}
				
				Request r = new Request(0, fname, lname, amount, eventDate,
						location, description, gradingFormat, eventType, justification, 1,employeeID,path,passing_grade);
				RequestDaoImpl r_dao = new RequestDaoImpl();
				try {
					r_dao.saveRequest(r);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HttpSession session = request.getSession(true);
				RequestDispatcher rd = null;
				if(session.getAttribute("title").equals("Employee")){
					rd = request.getRequestDispatcher("mainmenu.html");
					}
				else if(session.getAttribute("title").equals("Direct Supervisor"))
				{
					rd = request.getRequestDispatcher("mainmenuds.html");
				}
				rd.forward(request, response);
	}

}
