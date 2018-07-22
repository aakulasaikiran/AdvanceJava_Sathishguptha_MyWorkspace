//WelcomeServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  WelcomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
         PrintWriter pw=null;
	   //get PrintWriter 
	   pw=res.getWriter();
	   //set response content type
	   res.setContentType("text/html");
	   //write request processing logic
	    pw.println("<h1 style='text-align:center;color:red'>WelcomeServlet---Welcome page </h1>");
	   //close stream
	   pw.close(); 
	}//process
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
     doGet(req,res);
}
}//class
//>javac    -d    .   VoterServlet.java
