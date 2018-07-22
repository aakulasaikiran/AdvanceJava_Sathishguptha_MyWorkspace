package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String pval = null;
		int val1 = 0, val2 = 0;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read s1 request param value..
		pval = req.getParameter("s1");
		// write request processing logic
		if (pval.equalsIgnoreCase("link1")) {
			pw.println(System.getProperties());
		} else if (pval.equalsIgnoreCase("link2")) {
			pw.println(new Date());

		} else if (pval.equalsIgnoreCase("add")) {
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1>Sum is" + (val1 + val2) + "</h1>");
		} else if (pval.equalsIgnoreCase("sub")) {
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1>Sub is" + (val1 - val2) + "</h1>");
		} else {
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1>Mul is" + (val1 * val2) + "</h1>");
		}
		// add hyperlink
		pw.println("<a href='form.html'>home</a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)

}// class
