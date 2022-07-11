package com.cdac.component;

import org.springframework.stereotype.Component;

@Component
public class SBI implements Bank{

	public void withdraw(int atmId, int accNo, double amount) {
		
		System.out.println("Customer of SBI wants to withdraw money");
		
	}
	
}
