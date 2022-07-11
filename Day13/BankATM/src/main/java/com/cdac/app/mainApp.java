package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component1.ATM1;

public class mainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
//		ATM atm = (ATM) ctx.getBean("icici");		
//		atm.withdraw(23101999,150);
		/*
		Customer wants to withdraw money at ICICI Bank Atm 
		Customer of SBI wants to withdraw money
		*/
		
		//we are withdrawing balance from icici bank's ATM 
		ATM1 atm = (ATM1) ctx.getBean("icici2");
		atm.withdraw(1234, 500);	//accNo and money
		
		atm.withdraw(5678, 700);
	}

}

/*
Customer wants to withdraw money at ICICI Bank Atm 
Customer of BOM wants to withdraw money
Customer wants to withdraw money at ICICI Bank Atm 
Customer of SBI wants to withdraw money 
*/
 

