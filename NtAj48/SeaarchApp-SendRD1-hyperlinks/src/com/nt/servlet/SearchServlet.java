package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   String ss=null;
		  //general settings
		   res.setContentType("text/html");
		   pw=res.getWriter();
		   //read form data
		   ss=req.getParameter("tsearch");
		   //Generate Dynamic webpage having hyperlink to perform sendRedirection
		   pw.println("<h1 style='color:red'>Click the link below </h1>");
		   pw.println("<a href='https://www.google.co.in/search?q="+ss+"'>go</a>");
		   //close stream 
		   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
