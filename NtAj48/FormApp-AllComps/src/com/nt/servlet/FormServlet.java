package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int age=0;
		String name=null,addrs=null,gender=null,ms=null,qlfy=null;
		String []courses=null,hobbies=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		addrs=req.getParameter("addrs");
		gender=req.getParameter("gen");
		ms=req.getParameter("ms");
		qlfy=req.getParameter("qlfy");
		hobbies=req.getParameterValues("hb");
		courses=req.getParameterValues("courses");
		
		if(ms==null)
			ms="single";
		if(courses==null){
			courses=new String[1];
			courses[0]="no courses are selected--Wasting time in ameerpet";
		}
		if(hobbies==null){
			hobbies=new String[1];
			hobbies[0]="no hobies---> sanyasi";
		}
		
		
		//Generate result Message...
		if(gender.equalsIgnoreCase("M")){
			if(age<=5)
				pw.println("Master."+name+"  u r baby boy");
			else if(age<=12)
				pw.println("Master."+name+"  u r small boy");
			else if(age<=19)
				pw.println("Mr."+name+"  u r  teenage boy");
			else if(age<=35)
				pw.println("Mr."+name+"  u r  young man");
			else if(age<=50)
				pw.println("Mr."+name+" u r middle-aged man");
			else
				pw.println("Mr."+name+" u r budda man");
		}//if
		else{
			if(age<=5)
				pw.println("Master."+name+"  u r baby girl");
			else if(age<=12)
				pw.println("Master."+name+"  u r  small girl");
			else if(age<=19){
				if(ms.equals("married")){
				  pw.println("Mrs."+name+"  u r  teenage girl");
				}
				else{
   				  pw.println("Miss."+name+"  u r  teenage girl");
				}
			}
			else if(age<=35){
				if(ms.equals("married")){
					  pw.println("Mrs."+name+"  u r  young girl/woman");
					}
					else{
	   				  pw.println("Miss."+name+"  u r  young girl/woman");
					}
			}
			else if(age<=50){
				if(ms.equals("married")){
					  pw.println("Mrs."+name+"  u r  middle-aged woman");
					}
					else{
	   				  pw.println("Miss."+name+"  u r  middle-aged woman");
					}
			}
			else{
				if(ms.equals("married")){
					  pw.println("Mrs."+name+"  u r  old woman");
					}
					else{
	   				  pw.println("Miss."+name+"  u r  old woman");
					}
			}
		}//else
		//display form data
		pw.println("<h1 style='color:red;text-align:center'>Form data is </h1>");
		pw.println("<br>name==="+name);
		pw.println("<br>age==="+age);
		pw.println("<br>Gender==="+gender);
		pw.println("<br> Marital Status=="+ms);
		pw.println("<br>Address=="+addrs);
		pw.println("<br>qualification=="+qlfy);
		pw.println("<br>Courses=="+Arrays.toString(courses));
		pw.println("<br>hobbies=="+Arrays.toString(hobbies));
		//add hyperlink
		pw.println("<a href='form.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req,resp);
	}//doPost(-,-)
}//class
