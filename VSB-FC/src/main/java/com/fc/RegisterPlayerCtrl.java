package com.fc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/RegisterPlayerCtrl")
@MultipartConfig(maxFileSize=16177215)
public class RegisterPlayerCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver ="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vsbfc";
	String unm="root";
	String pwd="root";
       
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String playername=request.getParameter("playername").trim();
		String a=request.getParameter("age").trim();
		int age = Integer.parseInt(a);
		String city=request.getParameter("city").trim();
		String position=request.getParameter("position").trim();

		
		InputStream istrm = null;

		Part fp = request.getPart("profile");

			if(fp!= null) {
				System.out.println(fp.getName());
				System.out.println(fp.getSize());
				System.out.println(fp.getContentType());
				istrm=fp.getInputStream();
				}
			Connection con = null;
			String msg = null;
			try{
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				con =DriverManager.getConnection(url,unm,pwd);
				String sql = "insert into registerplayer (Playername, Age, City, Position, Profile) values(?, ?, ?, ?, ?) ";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, playername);
				pst.setInt(2, age);
				pst.setString(3, city);
				pst.setString(4, position);
				if(istrm!= null) {
					pst.setBlob(5, istrm);
						}
				int res = pst.executeUpdate();
				if(res>0) {
					msg ="Player data upload Successfully";
				}
				con.close();

		}catch(SQLException e) {

			e.printStackTrace();

		}
		
		
		
		
		
		
		
		ArrayList<String> list =new ArrayList<String>();
		if(playername.length()==0)
		  list.add("Enter Your Name");
		if(age<15)
			list.add("Enter Your Age");
		if(city.length()==0)
			list.add("Enter Your City");
		if(position.length()==0)
		   list.add("Enter Your Playing Position");
		if(!list.isEmpty()) {
			request.setAttribute("error",list);
			RequestDispatcher rd=request.getRequestDispatcher("RegisterPlayer");
					rd.forward(request,response);
					}
		
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Success.html").forward(request, response);
		
		
		
		
		
		
	}

}
