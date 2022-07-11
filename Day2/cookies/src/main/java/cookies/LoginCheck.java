package cookies;

public class LoginCheck {

	public boolean check(String username, String password) {
		
		if(username.equals("Aniket") && password.equals("aniket@2310"))
			return true;
		else
			return false;
		
	}

}
