package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("icici")
public class ICICIAtm implements ATM{
	
	@Autowired
	private Bank bank;
	
	public void withdraw(int accNo, double amount) {
		
		System.out.println("Customer wants to withdraw money at ICICI Bank Atm ");
		bank.withdraw(23101999, accNo, amount);
	}
	
	
}
