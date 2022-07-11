package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {
	
	@Autowired	//DI==>Dependency Injection
	private SpellChecker sc;
	
	public void load(String document) {
		System.out.println("loading document"+document);
		
		sc.checkMistakes(document);
	}
}
