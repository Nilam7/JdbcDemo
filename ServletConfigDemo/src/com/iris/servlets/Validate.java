package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		String s1=request.getParameter("email");
		String s2=request.getParameter("password");
		try {
		Connection conn=(Connection)getServletContext().getAttribute("connObj");
		PreparedStatement ps=conn.prepareStatement("select *from usertable where email=? and password=?");
		ps.setString(1,s1);
		ps.setString(2,s2);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			HttpSession session=request.getSession();
			session.setAttribute("userEmail",s1);session.setAttribute("userEmail",s1);
			String name=rs.getString(3)+" "+rs.getString(4);
			request.setAttribute("userName",name);
			RequestDispatcher rd=request.getRequestDispatcher("Welcome");
			rd.forward(request,response);
		}
		else{
			out.println("Email and password is Incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("form.html");
			rd.include(request,response);
		}
		
	}
	catch(Exception e){e.printStackTrace();}
		}

	

	}


