package com.revature.TRMS;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ObjectMapper om = new ObjectMapper();
		response.getWriter().write(request.getParameter("date"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		double amount = Double.parseDouble(request.getParameter("cost"));
		
		Date eventDate = null;
		Date eventTime = null;
		//2010-10-10T10:10 YYYY-MM-ddTHH:mm
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm");
        String dateInString = request.getParameter("date");
        String timeInString = request.getParameter("time");

        try {

            eventDate = (Date) formatter.parse(dateInString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		String location = request.getParameter("location");
		String description = request.getParameter("descr");
		String gradingFormat = request.getParameter("grading");
		String eventType = request.getParameter("type");
		String justification = request.getParameter("justification");
		
		Request r = new Request(0, fname, lname, amount, eventDate, eventTime,
				location, description, gradingFormat, eventType, justification);
		RequestDaoImpl r_dao = new RequestDaoImpl();
		try {
			r_dao.saveRequest(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().write(r.toString());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
