package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Myservlets")
public class Myservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		ServletContext context=getServletContext();
		
		String s1=context.getInitParameter("driverName");
		String s2=context.getInitParameter("connString");
		String s3=context.getInitParameter("userName");
		String s4=context.getInitParameter("userPass");
		
		out.println(s1+" <br/>"+s2+"<br/> "+s3+"<br/> "+s4);
	}

	
	}


