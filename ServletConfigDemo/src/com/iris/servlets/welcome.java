package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Welcome", urlPatterns = { "/Welcome" })
public class welcome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		//ServletContext context=getServletContext();
		String str=(String)request.getAttribute("userName");
		out.println("<div align='center' style='color:green;text-size:100px'>Welcome "+str);
		out.println("</br><a href='ViewProfile'>  View ");
		out.println("</br> <a href='ChangeProfile'>  change");

	}

}
