package life_cycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_lifecycle")
public class servlet_lifecycle extends HttpServlet {
	
	public servlet_lifecycle() {
		System.out.println("Constructor called..");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init method called..");
	}
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("service method called..");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method called...");
	}
}
