package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InboxServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String user=null;
		//general settings 
		pw=res.getWriter();
		res.setContentType("text/html");
		//get Authenticated and Authorized user details
		user=req.getRemoteUser();
		if(user.equalsIgnoreCase("rani")){
			pw.println("<b>Welcome CEO Madam</b>");
		}
		
		//Generate response
		pw.println("<h1 style='color:red'>Inbox Page </h1>");
		pw.println("<br><a href='index.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
