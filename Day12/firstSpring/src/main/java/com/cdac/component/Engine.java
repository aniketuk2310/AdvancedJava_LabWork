package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {
	
	public void run() {
		System.out.println("Vroom Vroom");
	}
	
	public void stop() {
		System.out.println("Phusssssssss");
	}
}
