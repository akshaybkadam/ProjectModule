package com.projectmodule.dao;

import java.util.*;

import com.projectmodule.dto.*;

import java.sql.*;
public class empDao{
	
	 public static Connection getConnection(){  
		Connection conn=null;  
	 	try {
	 		 	Class.forName("oracle.jdbc.driver.OracleDriver");  
	 		 	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","HR"); 
	        }catch(Exception e) {System.out.println(e);}
	         
	        return conn;
	  }
	 
	  public static int saveDetails(empPojo ep) {
		  int status = 0;
		  
		  try{  
	            Connection conn=empDao.getConnection();  
	            PreparedStatement ps=conn.prepareStatement("insert into Employee(name,password,email,country) values (?,?,?,?)");  
	            ps.setString(1,ep.getName());  
	            ps.setString(2,ep.getPassword());  
	            ps.setString(3,ep.getEmail());  
	            ps.setString(4,ep.getCountry());  
	              
	            status=ps.executeUpdate();  
	              
	            conn.close();  
	        }catch(Exception ex){ex.printStackTrace();} 
		  
		  return status;
	  } 
	  
	  public static List<empPojo> getAllEmployees() {
		  
		  List<empPojo> list=new ArrayList<empPojo>();
		  try {
			   	Connection conn = empDao.getConnection();
			   	PreparedStatement ps=conn.prepareStatement("select * from Employee");
			  	ResultSet rs = ps.executeQuery();
			  	
			  	while(rs.next()){  
			  		empPojo e=new empPojo();   
	                e.setName(rs.getString(1));  
	                e.setPassword(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setCountry(rs.getString(4));  
	                list.add(e);  
	            }  
			  	conn.close();  	  		
		  	}catch(Exception ex) {ex.printStackTrace();}
		  
		  return list;  
		  
	  }
	
}


