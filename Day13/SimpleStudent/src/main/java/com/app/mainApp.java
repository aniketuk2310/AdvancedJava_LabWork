package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.component.Student;

public class mainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		Student s1 = (Student) ctx.getBean("student1");
		
		System.out.println(s1);		//Student [id=101, name=Aniket, age=22, address=Baramati]
		
		Student s2 = (Student) ctx.getBean("student2");
		
		System.out.println(s2);		//Student [id=102, name=kale, age=44, address=Pune]
	}

}
