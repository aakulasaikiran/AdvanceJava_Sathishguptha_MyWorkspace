package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String  STUDENT_INSERT_QUERY="INSERT INTO LAYER_STUDENT VALUES(?,?,?,?,?)";
	private static final String  GET_STUDENT_NO="SELECT StudentId_seq.nextVal FROM DUAL";
	//get Connection obj from jdbc con pool
	private Connection getConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//create InitialCintext object
		ic=new InitialContext();
		//get DataSource object ref from Jndi Registry
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Connection obj from jdbc con pool
		con=ds.getConnection();
		return con;
	}//getConnection()
	
	public int getStudentNoByUsingSequence()throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//get Connection 
		con=getConnection();
		//create PreparedStatement
		ps=con.prepareStatement(GET_STUDENT_NO);
		//execute Query
		rs=ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		else
			return -1;
	}
	
	//persitence method
  public int insert(StudentBO bo)throws Exception{
	  Connection con=null;
	  PreparedStatement ps=null;
	  int sno=0;
	  int count=0;
	  //get Connection obj from jdbc con pool
	  con=getConnection();
	  //create PreparedStatement object
	  ps=con.prepareStatement(STUDENT_INSERT_QUERY);
	  //set values to Query params
	  //get Sequence numer as student Id
	  sno=getStudentNoByUsingSequence();
	  ps.setInt(1,sno);
	  ps.setString(2,bo.getSname());
	  ps.setInt(3,bo.getTotal());
	  ps.setFloat(4,bo.getAvg());
	  ps.setString(5,bo.getResult());
	  //send and execute Query
	  count=ps.executeUpdate();
	  if(count==1)
		  return sno;
	  else
	    return count;
    }//insert(-)
}//class
