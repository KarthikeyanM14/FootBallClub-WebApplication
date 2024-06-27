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

@WebServlet("/ViewPlayerList")
public class ViewPlayerList extends HttpServlet {
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
		 out.println("<marquee><h1>Registered Players List!!!!!</h1></marquee>");
		 out.println("<table border='1'><tr><th>Playername</th><th>Age</th><th>City</th><th>Position</th><th>Profile</th></tr></div>");
		 ResultSet rs=new RegisterDao().RetrievePlayer();
		 try {
			 while(rs.next())
			 {
				 out.println("<tr><th>"+rs.getString("Playername")+"</th><th>"+rs.getString("Age")+"</th><th>"+rs.getString("City")+"</th><th>"+rs.getString("Position")+"</th><th>"+rs.getBlob("Profile")+"</th></tr>");
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
