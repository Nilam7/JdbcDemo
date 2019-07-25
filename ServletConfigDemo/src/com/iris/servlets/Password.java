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

/**
 * Servlet implementation class Password
 */
@WebServlet("/Password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		String s1=request.getParameter("password1");
		String s2=request.getParameter("password2");
		try {
		Connection conn=(Connection)getServletContext().getAttribute("connObj");
		PreparedStatement ps=conn.prepareStatement("update *from usertable where password1=?");
		ps.setString(1,s1);
		ps.setString(2,s2);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			HttpSession session=request.getSession();
			session.setAttribute("userEmail",s1);session.setAttribute("userEmail",s1);
		}
	}
		catch(Exception e){e.printStackTrace();}
	}

	}


