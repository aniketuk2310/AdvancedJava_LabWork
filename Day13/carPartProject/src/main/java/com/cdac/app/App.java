package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.CarPart;
import com.cdac.component.CarPartsInventory;

public class App {

	public static void main(String[] args) {
		
		//loading Spring/IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		//implementation-1
		CarPartsInventory inv1 = (CarPartsInventory) ctx.getBean("carParts1");	//spring is making object for us
		
		//model/entity classes are not instantiated using Spring
		//we have to make the objects on our own in such case
/*		CarPart cp = new CarPart();
		cp.setPartName("Doors");
		cp.setCarModel("HONDA City");
		cp.setPrice(500);
		cp.setQuantity(4);
		
		long ms1 = System.currentTimeMillis();
		inv1.addnewPart(cp);
		long ms2 = System.currentTimeMillis();
		
		System.out.println("Total time taken executing Query : "+(ms2 - ms1)+ " milliSeconds approx.");
*/		
		
		//implementation-2
		
		System.out.println("implementation-2");
		
		CarPartsInventory inv2 = (CarPartsInventory) ctx.getBean("carParts2");
		
		CarPart cp1 = new CarPart();
		cp1.setPartName("Head Lights");
		cp1.setCarModel("Altroz");
		cp1.setPrice(1200);
		cp1.setQuantity(50);
		
		long ms3 = System.currentTimeMillis();
		inv2.addnewPart(cp1);
		long ms4 = System.currentTimeMillis();
		System.out.println("Total time taken executing Query : "+(ms4 - ms3)+ " milliSeconds approx.");
	}

}


/*
*for second implementation we used dataSource(connection pool) in which we are opening the connections to interact with the database 
initially itself..and then just using that connection after for executing our queries...

*for using dataSource we have to predefine the number of connection(initialSize)(3 in our case) in springCongig.xml file..

*and also we have to add one dependency in pom.xml file of "commons-dbcp2" (Database Connection Pools)
*/
