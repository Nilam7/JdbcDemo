package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewProfile() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//ServletConfig config=getServletConfig();
		//ServletContext context=getServletContext();

		try {
			Connection conn=(Connection)getServletContext().getAttribute("connObj");
			HttpSession session=request.getSession();
			String mail =(String)session.getAttribute("userEmail");
			PreparedStatement ps=conn.prepareStatement("select *from usertable where email=?");
			ps.setString(1,mail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.println("Details : "+" "+"<br />Email: "+rs.getString(1)+"   "+"<br />Password: "+rs.getString(2)+"  "+"<br />First Name : "+rs.getString(3)+"  "+"<br /> Last Name: "+rs.getString(4));}
			else{out.println("cannot find data");}
		}
		catch(Exception e){e.printStackTrace();}
	}

	
	}


