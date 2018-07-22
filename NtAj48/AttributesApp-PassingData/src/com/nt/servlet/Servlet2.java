package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null; 
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
         //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		//read request attribute values
		 pw.println("<br>(Servlet2) attr1(request) attribute value::"+req.getAttribute("attr1"));
		 //read session attribute values
		 ses=req.getSession();
		 pw.println("<br>(servlet2) attr2(session) attribute value"+ses.getAttribute("attr2"));
		 //read ServletContext attribute values
		 sc=getServletContext();
		 pw.println("<br>(Servlet2) attr3(Servletcontext) attribute value:"+sc.getAttribute("attr3"));
		 //forward the request to Servlet3
		 rd=req.getRequestDispatcher("/s3url");
		 rd.forward(req,res);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
