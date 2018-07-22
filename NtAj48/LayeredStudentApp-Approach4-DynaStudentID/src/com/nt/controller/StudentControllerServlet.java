package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentControllerServlet extends  HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String sno=null;
		String name=null;
		String m1=null,m2=null,m3;
		StudentVO  stVO=null;
		StudentDTO stDTO=null;
		StudentService service=null;
		String result=null;
	   //general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		sno=req.getParameter("sno");
		name=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//create StduentVO class object
		stVO=new StudentVO();
		stVO.setSname(name);
		stVO.setM1(m1);
		stVO.setM2(m2);
		stVO.setM3(m3);
		//covert VO class obj DTO class object
		stDTO=new StudentDTO();
		stDTO.setSname(name);
		stDTO.setM1(Integer.parseInt(stVO.getM1()));
		stDTO.setM2(Integer.parseInt(stVO.getM2()));
		stDTO.setM3(Integer.parseInt(stVO.getM3()));
		//use Service Class 
		service=new StudentService();
		try{
		result=service.generateResult(stDTO);
		pw.println("<h1>Result:::"+result+"</h1>");
		}//try
		catch(Exception e){
			pw.println("<h1>Internalm Problem:::"+e.getMessage()+"</h1>");
		}
		
		//add hyperlink
		pw.println("<a href='register.html'>home</a>");
		//close stream
		pw.close();
    }//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

	
}//class
