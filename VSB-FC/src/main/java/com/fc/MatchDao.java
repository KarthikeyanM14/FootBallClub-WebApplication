package com.fc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MatchDao {
	Connection con;
	PreparedStatement pst;
	ResultSet rs; 
	public MatchDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbfc","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet RetrieveMatch(){
		
	      try {
	    	  String sql="Select Title, Place, Date from matchdetails";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
	      } catch (SQLException e) {
			e.printStackTrace();
		} return rs;

		
	}

	public void Storedata(Match m) {
	                   String sql="insert into matchdetails(Title, Place, Date) values(?,?,?)";
	                   try {
							pst=con.prepareStatement(sql);
						
	                	   pst.setString(1, m.getTitle());
	                	   pst.setString(2, m.getPlace());
	                	   pst.setString(3, m.getDate());
	                	   pst.executeUpdate();
	                	   } 
	                	   catch (SQLException e) {
								e.printStackTrace();
							    }
	                   	}
	}
