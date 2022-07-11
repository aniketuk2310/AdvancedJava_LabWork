package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("login")
public class LoginService {
	
	public boolean checkLogin(String username, String password) {
		
		if(username.equals("aniket") && password.equals("aniket@2310"))
			return true;
		return false;
	}
}
