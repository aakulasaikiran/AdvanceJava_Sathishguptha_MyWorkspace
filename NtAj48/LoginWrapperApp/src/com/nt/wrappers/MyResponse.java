package com.nt.wrappers;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.sun.xml.internal.fastinfoset.util.CharArrayArray;

public class MyResponse extends HttpServletResponseWrapper {
    CharArrayWriter writer=null; 
	public MyResponse(HttpServletResponse response) {
		super(response);
		writer=new CharArrayWriter();
	}
	
	public PrintWriter getWriter(){
		return new PrintWriter(writer);
	}
	
	@Override
	public String toString() {
		return writer.toString();
	}

}
