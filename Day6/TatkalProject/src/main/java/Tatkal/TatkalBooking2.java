package Tatkal;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TatkalBooking2")
public class TatkalBooking2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		ServletConfig scfg = getServletConfig();
		LocalTime startTime = LocalTime.parse(scfg.getInitParameter("startTime"));
		
		LocalTime currTime = LocalTime.now();
		System.out.println(currTime);
		if(currTime.isAfter(startTime))
			out.println("<h1>You are on time, please proceed with the booking.</h1>");
		else
			out.println("<h1>Sorry, Tatkal booking is not available now.</h1>");
		
	}

}
