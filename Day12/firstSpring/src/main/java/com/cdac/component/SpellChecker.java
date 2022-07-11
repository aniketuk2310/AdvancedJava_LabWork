package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("splchkr")
public class SpellChecker {
	
	public void checkMistakes(String document) {
		System.out.println("Checking spelling mistakes in :"+document);
	}
}
