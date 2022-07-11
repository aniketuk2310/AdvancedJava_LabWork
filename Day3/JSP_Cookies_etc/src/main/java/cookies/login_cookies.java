package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login_cookies")
public class login_cookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		LoginCheck lc = new LoginCheck();
		
		boolean valid = lc.check(username,password);
		
		if(valid) {
			String rememberMe = request.getParameter("rememberMe");
			
			if(rememberMe != null && rememberMe.equals("true")) {
				Cookie c1 = new Cookie("username",username);
				c1.setMaxAge(60 * 60 * 24);
				Cookie c2 = new Cookie("password",password);
				c2.setMaxAge(60 * 60 * 24);
				
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("Welcome.html");
		}
		else
			response.sendRedirect("login.html");
		
	}

	

}
