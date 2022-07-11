package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("CurrCon")
public class CurrencyConvertor {
	
	public double check(String from, String to, double amount) {
		
		if(from.equals("USD") && to.equals("INR")) 
			return amount*79.11;
		
		else if(from.equalsIgnoreCase("Pounds") && to.equalsIgnoreCase("INR"))
			return amount*94.96;
		
		return 0;
	}
}
