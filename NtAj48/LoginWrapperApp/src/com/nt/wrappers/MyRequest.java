package com.nt.wrappers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
     private HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	
	public String getParameter(String name){
		String pval=null;
		//read form data
		pval=request.getParameter(name);
		if(name.equals("uname")){
			if(pval.indexOf("@gmail.com")==-1){
				pval=pval+"@gmail.com";
			}
		}
		return pval;
	}//method

}
