package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	
	@Autowired
	private Engine e;
	
	public void key() {
		e.run();
		e.stop();
	}
}
