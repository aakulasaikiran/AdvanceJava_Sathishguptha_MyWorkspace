package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/formurl")
//@WebServlet(value="/formurl",name="bcd",loadOnStartup=2)
//@WebServlet(urlPatterns={"/formurl","/formurl1"},name="abc",loadOnStartup=1)
//@WebServlet(urlPatterns="/formurl",name="abc")
//@WebServlet("/formurl")
//@WebServlet("/")
@WebServlet(urlPatterns = "/formurl", name = "abc", initParams = { @WebInitParam(name = "dbuser", value = "SAIKIRAN"),
		@WebInitParam(name = "dbpwd", value = "SAIKIRAN") })
public class FormServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null;
		ServletConfig cg = null;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form data
		name = req.getParameter("name");
		pw.println("<h1> Hello :: Mr:" + name + "</h1>");
		// add hyperlink
		pw.println("<h1 style=\"color: red\">Home Page</h1>");
		pw.println("<a href='form.html'>home</a>");
		// read and display init params
		cg = getServletConfig();
		pw.println("<br> dbuser init param ::" + cg.getInitParameter("dbuser"));
		pw.println("<br>dbpwd init param ::" + cg.getInitParameter("dbpwd"));
		pw.close();
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
