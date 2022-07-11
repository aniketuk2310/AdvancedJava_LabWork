package com.cdac.component1;

import org.springframework.stereotype.Component;

@Component("sbi")
public class SBI1 implements Bank1{

	public boolean isAccPresent(int accNo) {	//checking account in sSBI
		if(accNo == 5678)
			return true;
		return false;
	}
	
	public void withdraw(int atmId, int accNo, double amount) {
		
		System.out.println("Customer of SBI wants to withdraw money");
		
	}
	
}
