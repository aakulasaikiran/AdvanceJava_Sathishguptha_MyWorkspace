package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int value=0;
		int cube=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		value=Integer.parseInt(req.getParameter("t1"));
		//calculate cube value..
		cube=value*value*value;
		pw.println("<br>SecondSErvlet--> cube  value::"+cube);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class
