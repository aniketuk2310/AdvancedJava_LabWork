package ak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/run")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname = request.getParameter("fullname");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Hello "+ fullname.toUpperCase() + "</h1>");
		out.write("<h1 style='color : green;'>How are you??</h1>");
		out.write("<h1 style='color : red;'>Hello "+ fullname.toUpperCase() + "</h1>");
		out.write("</body></html>");
	}

}

//
//Hello ANIKET KALE
//How are you??
//Hello ANIKET KALE
