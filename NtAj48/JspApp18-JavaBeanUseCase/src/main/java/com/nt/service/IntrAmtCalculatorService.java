package com.nt.service;

import com.nt.dto.IntrAmtDetailsDTO;

public class IntrAmtCalculatorService {
	
	
	public void calcIntrAmt(IntrAmtDetailsDTO dto){
		float intrAmt=0.0f;
		//calc Intr Amount
		intrAmt=(dto.getpAmt()*dto.getTime()*dto.getRate())/100.0f;
		//set IntrAmount dto
		dto.setIntrAmt(intrAmt);
	}//method
}//class
