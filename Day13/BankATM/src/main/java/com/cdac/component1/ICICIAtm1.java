package com.cdac.component1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("icici2")
public class ICICIAtm1 implements ATM1{
	
	@Autowired
	private List<Bank1> banks; 	//becoz there will be multiple banks
	
	public void withdraw(int accNo, double amount) {
		
		System.out.println("Customer wants to withdraw money at ICICI Bank Atm ");
		
		Bank1 currentBank = null;
		
		for(Bank1 bank : banks) {				//checking the given accNo present in respective bank or not(checking for each bank in list) 
			if(bank.isAccPresent(accNo)) {
				currentBank = bank;
				break;
			}
		}
		currentBank.withdraw(231099, accNo, amount);	//calling current banks withdraw method having that accNo present in it
	}
	
	
}
