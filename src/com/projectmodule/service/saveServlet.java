package com.projectmodule.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectmodule.pojo.*;
import com.projectmodule.dao.*;
 
@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
   
    	String name = request.getParameter("uname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String country = request.getParameter("country");	
    	
    	empPojo ep = new empPojo();
    	
    	 ep.setName(name);  
         ep.setPassword(password);  
         ep.setEmail(email);  
         ep.setCountry(country);  
    	
         PrintWriter out = response.getWriter();
         
         int status = empDao.saveDetails(ep);  
         if(status>0){  
         	out.write(name);  
         }else{  
         	out.write("error");
         }  
         
         
         out.close();  
    	
    	 
    	//response.getWriter().write("Hello");
    }
}