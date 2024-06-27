package com.fc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpcomingDetails")
public class UpcomingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<link rel='stylesheet' href='style.css'>");
         out.println("</head>");		
		 out.println("<body>");
		 out.println("<center>");
		 out.println("<div class='t'>");
		 out.println("<marquee><h1>Upcoming Matches!!!!!</h1></marquee>");
		 out.println("<table border='1'><tr><th>Title</th><th>Place</th><th>Date</th></tr></div>");
		 ResultSet rs=new MatchDao().RetrieveMatch();
		 try {
			 while(rs.next())
			 {
				 out.println("<tr><th>"+rs.getString("Title")+"</th><th>"+rs.getString("Place")+"</th><th>"+rs.getString("Date")+"</th></tr>");
			}
		 }catch(SQLException e) {
		 }
		 out.println("</table></center></body</head>");
	
	
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
