package com.cdac.component1;

import org.springframework.stereotype.Component;

@Component("bom")
public class BOM1 implements Bank1{

	public boolean isAccPresent(int accNo) {	//checking account in Bank of MH
		if(accNo == 1234)
			return true;
		return false;
	}
	
	public void withdraw(int atmId, int accNo, double amount) {
		
		System.out.println("Customer of BOM wants to withdraw money");
		
	}

}
