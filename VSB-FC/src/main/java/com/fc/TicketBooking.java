package com.fc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TicketBooking")
public class TicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list=(ArrayList<String>)request.getAttribute("error");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");
		if(list!=null) {
			Iterator <String> itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext()) {
				out.println("<li>"+itr.next()+"</li>");
			    }
				out.println("</ul>");
			
			
		}
		out.println("<center>");
		out.println("<div class=k>");
		out.println("<h1>Book Your Tickets!!!!</h1>");
		out.println("<form action='TicketBookingCtrl' method='post'><br><br>");
		out.println("<input type='text' name='name'placeholder='Name'><br><br>");
		out.println("<input type='text' name='num' placeholder='No.of.Tickets'><br><br>");
		out.println("<input type='submit' name='Submit'><br><br>");
		out.println("</form></div>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
