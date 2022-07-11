package com.cdac.component;

import java.util.List;

public class Person {
	
	private String name;
	private int age;
	private List<String> phones;
	
	public Person(String name, int age, List<String> phones) {
		super();
		System.out.println("Constructor called.!!");
		this.name = name;
		this.age = age;
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phones=" + phones + "]";
	}
}
