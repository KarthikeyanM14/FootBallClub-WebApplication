package com.fc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	Connection con;
	PreparedStatement pst;
	ResultSet rs; 
	public RegisterDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbfc", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet RetrievePlayer(){
		
	      try {
	    	  String sql="Select playername, age, city, position, profile from registerplayer";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
	      } catch (SQLException e) {
			e.printStackTrace();
		} return rs;

		
	}

	public void Storedata(Register r) {
	                   String sql="insert into registerplayer(Playername, Age, City, Position, Profile) values(?, ?, ?, ?, ?)";
	                   try {
							pst=con.prepareStatement(sql);
						
	                	   pst.setString(1, r.getPlayername());
	                	   pst.setString(2, r.getAge());
	                	   pst.setString(3, r.getCity());
	                	   pst.setString(4, r.getPosition());
	                	   pst.setString(5, r.getProfile());
	                	   pst.executeUpdate();
	                	   } 
	                	   catch (SQLException e) {
								e.printStackTrace();
							    }
	                   	}
}
