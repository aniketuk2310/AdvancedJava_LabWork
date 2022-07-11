package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Person;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		Person p = (Person) ctx.getBean("person");
		
		System.out.println(p);	//Person [name=Aniket, age=22] 
	
	}

}

/*
Constructor called.!!
Person [name=Aniket, age=22, phones=[Apple, OnePlus, POCO]]
*/