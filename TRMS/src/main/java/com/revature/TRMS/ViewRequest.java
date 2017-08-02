package com.revature.TRMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewRequest
 */
public class ViewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDaoImpl r_dao = new RequestDaoImpl();
		HttpSession session = request.getSession(true);
		int i = (int) session.getAttribute("userIDKey");
		ArrayList<Request> arr = null;
		arr = (ArrayList<Request>) r_dao.getAllidRequest(i);
		//r_dao.getAllRequest();
		if(!arr.isEmpty()) {
			PrintWriter out = response.getWriter();
			/*out.write("<p>First Name: "+arr.get(i-1).getFirstName()+"</p>");
			out.write("<p>Last Name: "+arr.get(i-1).getLastName()+"</p>");*/
			out.println("<html>");
			out.println("<head>");
			out.println("<style>table, th, td {"
					+ "border: 1px solid black;"
					+ "border-collapse: collapse;}"
					+ "th, td {padding: 5px;text-align: left;} </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>My Request:</h2>");
			out.println("<table style=\"width:100%\">");
			out.println("<tr>");
			out.println("<th>First Name:</th>");
			out.println("<td>"+arr.get(0).getFirstName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Last Name:</th>");
			out.println("<td>"+arr.get(0).getLastName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Amount:</th>");
			out.println("<td>"+arr.get(0).getAmount()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Event Date:</th>");
			out.println("<td>"+arr.get(0).getEventDate()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Location:</th>");
			out.println("<td>"+arr.get(0).getLocation()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Description:</th>");
			out.println("<td>"+arr.get(0).getDescription()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Grading Format:</th>");
			out.println("<td>"+arr.get(0).getGradingFormat()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Event Type:</th>");
			out.println("<td>"+arr.get(0).getEventType()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Justification:</th>");
			out.println("<td>"+arr.get(0).getJustification()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Status:</th>");
			out.println("<td>"+arr.get(0).getStatus()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>EmployeeID:</th>");
			out.println("<td>"+arr.get(0).getEmployeeID()+"</td>");
			out.println("</tr>");
			out.println("</table>");
			
			out.println("<form action=\"cancelRequest\">");
			out.println("<div class=\"form-group\">");
			out.println("<input id =\"cancelbtn\"  type=\"submit\" value=\"Cancel Request\">");
			out.println("</div>");
			out.println("<input type=\"hidden\" name=\"request\" value=\"" + arr.get(0).getRequestId() +"\">");
			out.println("</form>");
			
			/*out.println("<form action=\"approveDeny\">");
			out.println("<div class=\"form-group\">");
			out.println("<input id =\"approvebtn\"  type=\"submit\" value=\"Approve\" name=\"action\" >");
			out.println("<input id =\"denybtn\"  type=\"submit\" value=\"Deny\" name=\"action\" >");
			out.println("</div>");
			out.println("<script src=\"/ViewReQuest\"></script>");*/
			
			out.println("</body>");
			out.println("</html>");
		
			/*out.write("First Name: "+arr.get(i-1).getFirstName());
			out.write("Last Name: "+arr.get(i-1).getLastName());*/
			//response.getWriter().write("Do Something");
			//RequestDispatcher rd = request.getRequestDispatcher("viewinfo.html");
			//rd.forward(request, response);
			/*request.setAttribute("listData", listData);
		    RequestDispatcher rd = getServletContext()
		                               .getRequestDispatcher("/TRMS2/src/main/webapp/resources/js/file.jsp");
		    rd.forward(request, response);*/
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
