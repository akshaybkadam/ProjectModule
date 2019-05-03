package com.projectmodule.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
   
    	String name = request.getParameter("uname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String country = request.getParameter("country");	
    	
    	
    	
    	PrintWriter out = response.getWriter();
    	out.write(name);
    	 
    	//response.getWriter().write("Hello");
    }
}