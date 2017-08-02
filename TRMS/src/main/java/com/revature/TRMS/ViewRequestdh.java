package com.revature.TRMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewRequestdh
 */
public class ViewRequestdh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestdh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDaoImpl r_dao = new RequestDaoImpl();
		ArrayList<Request> arr = null;
		try {
			arr = (ArrayList<Request>) r_dao.getAllRequest();
			r_dao.getAllRequest();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		int i = (int) session.getAttribute("userIDKey");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>table, th, td {"
				+ "border: 1px solid black;"
				+ "border-collapse: collapse;}"
				+ "th, td {padding: 5px;text-align: left;} </style>");
		out.println("</head>");
		out.println("<style> body { background-image: url(blue.jpg); background-size: cover; } </style>");
		out.println("<body>");
		for(int num = 0; num < arr.size(); num++) {
		out.println("<h2>Request:</h2>");
		out.println("<form action=\"approveDeny\">");
		out.println("<table style=\"width:100%\">");
		
		
			out.println("<input type=\"radio\" name=\"request\" value=\"" + arr.get(num).getRequestId() + "\">");
			out.println("<tr>");
			out.println("<th>First Name:</th>");
			out.println("<td>"+arr.get(num).getFirstName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Last Name:</th>");
			out.println("<td>"+arr.get(num).getLastName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Amount:</th>");
			out.println("<td>"+arr.get(num).getAmount()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Event Date:</th>");
			out.println("<td>"+arr.get(num).getEventDate()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Location:</th>");
			out.println("<td>"+arr.get(num).getLocation()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Description:</th>");
			out.println("<td>"+arr.get(num).getDescription()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Grading Format:</th>");
			out.println("<td>"+arr.get(num).getGradingFormat()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Event Type:</th>");
			out.println("<td>"+arr.get(num).getEventType()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Justification:</th>");
			out.println("<td>"+arr.get(num).getJustification()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Status:</th>");
			out.println("<td>"+arr.get(num).getStatus()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>EmployeeID:</th>");
			out.println("<td>"+arr.get(num).getEmployeeID()+"</td>");
			out.println("</tr>");
			out.println("</input>");
			out.println("</table>");
			
			
			out.println("<div class=\"form-group\">");
			out.println("<input id =\"approvebtn\"  type=\"submit\" value=\"Approve\" name=\"action\" >");
			out.println("<input id =\"denybtn\"  type=\"submit\" value=\"Deny\" name=\"action\" >");
			out.println("</div>");
			out.println("</form>");
		}
		
		
		/*out.println("</table>");
		
		
		out.println("<div class=\"form-group\">");
		out.println("<input id =\"approvebtn\"  type=\"submit\" value=\"Approve\" name=\"action\" >");
		out.println("<input id =\"denybtn\"  type=\"submit\" value=\"Deny\" name=\"action\" >");
		out.println("</div>");
		out.println("</form>");*/
		//out.println("<script src=\"/ViewRequest\"></script>");
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
