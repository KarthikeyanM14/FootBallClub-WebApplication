package com.fc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddMatchDetailsCtrl")
public class AddMatchDetailsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title").trim();
		String place=request.getParameter("place").trim();
		String date=request.getParameter("date").trim();
		ArrayList<String> list =new ArrayList<String>();
		if(title.length()==0)
		  list.add("Enter title field");
		if(place.length()==0)
			list.add("Enter place field");
		if(date.length()==0)
			list.add("Enter date field");
		if(!list.isEmpty()) {
			request.setAttribute("error",list);
			RequestDispatcher rd=request.getRequestDispatcher("AddMatchDetails");
					rd.forward(request,response);
					}
		Match m=new Match(title,place,date);
		MatchDao md=new MatchDao();
		md.Storedata(m);
		RequestDispatcher rd1=request.getRequestDispatcher("Ack.html");
		rd1.forward(request,response); 
      	}

}
