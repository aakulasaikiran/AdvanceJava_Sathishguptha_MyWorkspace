package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int val=0,square=0;
		ServletContext sc=null,sc1=null;
		RequestDispatcher rd=null;
		//general settigs
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val=Integer.parseInt(req.getParameter("t1"));
		//calculte square vlaue
		square=val*val;
		pw.println("FirstServlet-->Square::"+square);
		
		//get Servletcontext obj of "WATwo" web application 
		  //get Servletcontext obj of current web application(WAOne)
		   sc=getServletContext();
		 //get Servletcontext obj of WATwo web application
		   sc1=sc.getContext("WATwo-CrossContext");
		 //create RequestDispatcher obj holding SecondServlet of WATwo
		   rd=sc1.getRequestDispatcher("/surl");
		 //include the response 
		   rd.include(req,res);
	}//doGet(req,res);
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
  }//class
