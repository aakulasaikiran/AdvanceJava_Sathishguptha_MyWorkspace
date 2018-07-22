//VoterServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class  VoterServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("VoterServlet:doGet(-,-)");
         PrintWriter pw=null;
		 int age=0;
		 String tage=null,name=null;
         List<String> errsList=null;
		 String vstatus=null;
	   //get PrintWriter 
	   pw=res.getWriter();
	   //set response content type
	   res.setContentType("text/html");
	   //read form data (request parameter values)
	   name=req.getParameter("pname");
	   tage=req.getParameter("page");
	   //read vflag value to know wheather client side form validations  are done or not
	   vstatus=req.getParameter("vflag");
	   if(vstatus.equalsIgnoreCase("no")){
	   //form validation logics (server side )
	   System.out.println("server side form validation logic.....");
	   errsList=new ArrayList<String>();
	   if(name==null || name.equals("") || name.length()==0){  //required rule
          errsList.add("person name is required");
	   }//if
	   if(tage==null || tage.equals("") || tage.length()==0){ //required rule
		   errsList.add("person age is required");
	   }
	   else{  //age  must be numeric value
		   try{
            age=Integer.parseInt(tage);
		   }//try
		   catch(NumberFormatException nfe){
			   errsList.add("person age must be numberic value");
		   }//catch
	   }//else

	   //Display form validation Error messages
	   if(errsList.size()>0){
     	   for(int i=0;i<errsList.size();++i){
                pw.println("<li style='color:red'>"+errsList.get(i)+"</li>");
		   } //for
		   return;
	   }//if 
	  }//if
	  else{
           age=Integer.parseInt(tage);
	  }


	   //write request processing logic (b.logic)
	   if(age>=18)
		   pw.println("<marquee><h1 style='color:green'> Mr/Miss/Mrs"+name+"  u r elgible to vote </h1></marquee>");
	   else
		   pw.println("<marquee><h1 style='color:red'> Mr/Miss/Mrs"+name+"  u r  not elgible to vote </h1></marquee>");
	    //add graphicaly hyperlink
		pw.println("<a href='input.html'><img src='javababa.png'></a>");
	   //close stream
	   pw.close(); 
	}//process(-,-)

public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("VoterServlet:doPost(-,-)");
    doGet(req,res);
}
}//class
//>javac    -d    .   VoterServlet.java
