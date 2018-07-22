package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	public String generateResult(StudentDTO dto)throws Exception{
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		StudentDAO dao=null;
		int count=0;
		//Write b.logic to get total,avg and result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<=35)
			result="fail";
		else
			result="pass";
		//prepare BO class obj having persistable data
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//Create DAO class object
		dao=new StudentDAO();
		count=dao.insert(bo);
		if(count==0)
			return "Registration failed -->Result:::"+result;
		else
			return count+"StudentId Student Registration is succeded--->Result:::"+result;
	}//method
}//class
