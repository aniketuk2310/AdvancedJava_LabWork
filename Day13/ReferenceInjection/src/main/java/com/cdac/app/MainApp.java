package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.A;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		A a = (A) ctx.getBean("aref");
		
		System.out.println(a);	//A [x=200, obj=B [y=100]]
		
		System.out.println(a.getX());	//200
		System.out.println(a.getObj().getY());	//100
	}

}

/*
A [x=200, obj=B [y=100]]
200
100
*/