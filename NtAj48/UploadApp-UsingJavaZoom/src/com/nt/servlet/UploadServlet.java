package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.function.BiConsumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class UploadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final PrintWriter pw=res.getWriter();
		MultipartFormDataRequest nreq=null;
		UploadBean bean=null;
		Hashtable<String,UploadFile> ht=null;
		Enumeration e=null;
		UploadFile file=null;
		//general settings
		//res.setContentType("text/html");
		res.setContentType("application/vnd.ms-excel");
		res.addHeader("Content-Disposition","attachment;fileName='title.xls'");
		try{
		//Create Special Request object
		nreq=new MultipartFormDataRequest(req);
		//perform file  uploading settings
		bean =new UploadBean();
		bean.setFolderstore("E:/store");
		bean.setOverwrite(false);
		bean.setMaxfiles(10);
		bean.setFilesizelimit(102400);
		//upload the file
		bean.store(nreq);
		//Display the uploaded file..
		pw.println("<h1>Uploaded file </h1>");
         ht=nreq.getFiles();
	
    ht.forEach((k,v)->{
	  pw.println("<br>"+"key:"+k+"..."+v.getFileName()+".."+v.getFileSize());
	});
		
		/*e=ht.elements();
		pw.println("<h1>The uploaded files are </h1>");
		while(e.hasMoreElements()){
			file=(UploadFile) e.nextElement();
			pw.println("<br>"+file.getFileName()+"...."+file.getFileSize());
		}*/
		//Add hyperlink
		pw.println("<a href='upload.html'>home</a>");
		}//try
		catch(Exception ex){
			pw.println("<h1>Problems in file uploading</h1>");
			ex.printStackTrace();
			
		}
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
