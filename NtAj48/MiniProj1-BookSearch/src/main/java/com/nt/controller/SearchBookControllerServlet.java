package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.SearchBookService;
import com.nt.service.SearchBookServiceImpl;

@WebServlet("/controller")
public class SearchBookControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   String category=null;
	   String action=null;
	   SearchBookService service=null;
	   List<BookDTO> listDTO=null;
	   RequestDispatcher rd=null;
	   String target_page=null;
	   
		//read form data
	   category=req.getParameter("category");
	   //category=req.getParameterNames("category");
	   action=req.getParameter("source");
	   //create Service class object
	   service=new SearchBookServiceImpl();
	   try{
	    listDTO=service.searchBooks(category);
	    //keep result in request scope
	    req.setAttribute("booksList",listDTO);
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   rd=req.getRequestDispatcher("/error.jsp");
		   rd.forward(req,res);
		   return;
	   }
	   //decide result/target page based on the button that is clicked
	   if(action.equalsIgnoreCase("html")){
		   target_page="/html_print.jsp";
	   }
	   else{
		   target_page="/excel_screen.jsp";
	   }
	   //forward the request
	   rd=req.getRequestDispatcher(target_page);
	   rd.forward(req,res);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
