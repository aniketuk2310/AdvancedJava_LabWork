package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		
		Employee employee = (Employee) ctx.getBean("emp");
		
		System.out.println(employee);
		
		System.out.println(employee.getName());
		System.out.println(employee.getAddresses());
		System.out.println(employee.getPhones());
		System.out.println(employee.getCourses());
		System.out.println(employee.getProps());
	}

}
/*
Employee [name=Radhe, phones=[8390571799, 8766594551, 9422987143], addresses=[Sangavi, Kambleshwar, Baramati, Pune, Mumbai], courses={Core Java=3_Months, Adv_Java=2_Months, Python=1_Months}, props={Qualification=PG-DAC, Age=22, Name=Aniket}]
Radhe
[Sangavi, Kambleshwar, Baramati, Pune, Mumbai]
[8390571799, 8766594551, 9422987143]
{Core Java=3_Months, Adv_Java=2_Months, Python=1_Months}
{Qualification=PG-DAC, Age=22, Name=Aniket}
*/