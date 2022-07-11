package com.cdac.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.Car;
import com.cdac.component.CurrencyConvertor;
import com.cdac.component.Engine;
import com.cdac.component.HelloWorld;
import com.cdac.component.LoginService;
import com.cdac.component.TextEditor;

public class mainApp {

	public static void main(String[] args) {
		//Loading Spring/IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		//=======================================================================
		
		//Accessing a particular bean
		//spring is making object(singleton) of HelloWorld class
		HelloWorld hw = (HelloWorld) ctx.getBean("hello");	//getting object of class HelloWorld by its id
		System.out.println(hw.saySomething("Aniket"));
		
		//=======================================================================
		
		Calculator cal = (Calculator) ctx.getBean("calc");	//getting object of class Calculator by its id
		System.out.println(cal.add(25, 25));
		System.out.println(cal.sub(10, 5));
		
		//=======================================================================
		
		CurrencyConvertor cc = (CurrencyConvertor) ctx.getBean("CurrCon");
		System.out.println(cc.check("USD", "INR", 100));
		System.out.println(cc.check("Pounds", "INR", 100));
		
		//=======================================================================
		
		LoginService lo = (LoginService) ctx.getBean("login");
		boolean result  = lo.checkLogin("aniket", "aniket@2310");
		if(result) System.out.println("Successfull login..!!");
		else System.out.println("Something went wrong");
		
		//=======================================================================
		
		Car car = (Car) ctx.getBean("car");
		car.key();
		
		//=======================================================================
		
		TextEditor txt = (TextEditor) ctx.getBean("txtEdtr");
		txt.load("abc.txt");
	}

}

/*
Hey Aniket
50
5
7911.0
9496.0
Successful login..!!
Vroom Vroom
Phusssssssss
loading documentabc.txt
Checking spelling mistakes in :abc.txt
*/