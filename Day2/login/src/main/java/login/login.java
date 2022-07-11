package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		out.write("<html><body>");
//		out.write("<h1>Login Successfull..</h1>");
//		out.write("</body></html>");
		
		LoginCheck lc = new LoginCheck();
		
		boolean result =lc.check(username,password);
		
		if(result)
//			out.write("<h1>Login Successfull..</h1>");
			response.sendRedirect("Success.html");		//routing to Success.html page
		else
//			out.write("<h1>Invalid username or Password..</h1>");
			response.sendRedirect("login.html");		//routing to login.html page
	}

}
