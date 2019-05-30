package com.projectmodule.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;  

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.projectmodule.dao.*;
import com.projectmodule.dto.*;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Gson gson;
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
		 response.setContentType("application/json;charset=UTF-8");
		 ServletOutputStream out = response.getOutputStream();
		 
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	
    	List<empPojo> list=empDao.getAllEmployees();  
    	
    	 gson = new GsonBuilder().create();
    	 JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
         JsonObject jsonObject = new JsonObject();
         jsonObject.add("list", jarray);
    	
    	// PrintWriter out = response.getWriter();
    	// out.write("success");
        
        out.print( jsonObject.toString());
	}

}
