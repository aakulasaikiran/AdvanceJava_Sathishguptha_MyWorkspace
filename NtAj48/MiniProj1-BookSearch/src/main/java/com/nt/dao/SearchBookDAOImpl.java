package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class SearchBookDAOImpl implements SearchBookDAO {
 private static final String  GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,AUTHORNAME,STATUS,CATEGORY FROM SELECT_BOOKS WHERE CATEGORY=?";	
	private  Connection  getConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//get Connection object from jdbc con pool
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
		return con;
	}

	@Override
	public List<BookBO> findBooks(String category) throws Exception {
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		List<BookBO> list=null;
		BookBO bo=null;
		//get Connection obj from jdbc con pool
		con=getConnection();
		//exute SQL Query and get ResultSet object
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		ps.setString(1,category);
		rs=ps.executeQuery();
		System.out.println("size:"+ps.toString());
		System.out.println(ps);
		//Copy ResultSet records to ArrayList as BookBO class object
		list=new ArrayList();
		while(rs.next()){
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthorName(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setCategory(rs.getString(5));
			list.add(bo);
		}
		System.out.println("DAO:::"+list.size());
		return list;
	}

}
