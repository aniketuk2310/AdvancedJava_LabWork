package ak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ass1_2")
public class Ass1_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		if(request.getParameter("b1") != null) {
			out.write("<h1>Addition is : "+(num1 + num2)+"</h1>");
		}
		else if(request.getParameter("b2") != null) {
			out.write("<h1>Substraction is : "+(num1 - num2)+"</h1>");
		}
		else if(request.getParameter("b3") != null) {
			out.write("<h1>Multiplication is : "+(num1 * num2)+"</h1>");
		}
		else if(request.getParameter("b4") != null) {
			out.write("<h1>Division is : "+(num1 / num2)+"</h1>");
		}
	}

}
