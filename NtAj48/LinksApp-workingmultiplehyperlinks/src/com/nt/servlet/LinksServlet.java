package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pvalue=null;
		Locale locales[]=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read additional Request param value(s1)
		pvalue=req.getParameter("s1");
		//Differentiate the logic based on the hyperlink that is clicked
	    if(pvalue.equalsIgnoreCase("link1")){
	    	pw.println("<h1> All countries are </h1>");
	    	//display country details
	    	locales=Locale.getAvailableLocales();
	    	for(Locale l:locales){
	    		pw.println("<b>"+l.getDisplayCountry()+"</b><br>");
	    	}
	    }
	    else if(pvalue.equalsIgnoreCase("link2")){
	    	//display language details
	    	pw.println("<h1> All Lanugages are </h1>");
	    	locales=Locale.getAvailableLocales();
	    	for(Locale l:locales){
	    		pw.println("<b>"+l.getDisplayLanguage()+"</b><br>");
	    	}
	    }
	    else{
	    	pw.println("<br> System Date:::"+new Date());
	    }
	    //add hyperlink
	    pw.println("<a href='links.html'>home</a>");
	    //close stream 
	    pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
