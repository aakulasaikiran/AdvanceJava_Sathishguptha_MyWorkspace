package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrappers.MyRequest;
import com.nt.wrappers.MyResponse;
@WebFilter("/loginurl")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mreq=null;
		MyResponse mres=null;
		String output=null;
		PrintWriter pw=null;
		//create Custom Request obj
		mreq=new MyRequest(((HttpServletRequest)req));
		mres=new MyResponse(((HttpServletResponse)res));
		//delegate request
		chain.doFilter(mreq,mres);
		//get response content
		output=mres.toString();
		//modify output
		output=output+"<br> Naresh IT,Ameerpet";
		//write modified output to orginal response obj to write to browser
		pw=res.getWriter();
		pw.println(output);
		//close stream
		pw.close();
	}//doFilter(-,-,-)

}
