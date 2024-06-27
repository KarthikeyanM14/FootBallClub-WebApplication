package com.fc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TicketBookingCtrl")
public class TicketBookingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =request.getParameter("name").trim();
		String a=request.getParameter("num").trim();
		int num=Integer.parseInt(a);
		ArrayList<String> list =new ArrayList<String>();
		if(name.length()==0)
		  list.add("Enter Your Name");
		if(num<1)
			list.add("Enter  No. Of Seats");
		
		if(!list.isEmpty()) {
			request.setAttribute("error",list);
			RequestDispatcher rd=request.getRequestDispatcher("TicketBooking");
					rd.forward(request,response);
					}
		request.setAttribute("nm", list);
		getServletContext().getRequestDispatcher("/ticket.html").forward(request, response);
	}

		
		
		
		
		
	}

