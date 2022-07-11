package Tatkal;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/TatkalServlet")
public class TatkalServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TatakalServlet is loaded");
		PrintWriter out = response.getWriter();
		
		ServletConfig scfg = getServletConfig();
		int startTime = Integer.parseInt(scfg.getInitParameter("startTime"));
		int endTime = Integer.parseInt(scfg.getInitParameter("endTime"));
		
		LocalTime time = LocalTime.now();
		int timeRightNow = time.getHour();
		
		if(timeRightNow >= startTime && timeRightNow <= endTime)
			out.println("<h1>You are on time, please proceed with the booking.</h1>");
		else
			out.println("<h1>Sorry, Tatkal booking is not available now.</h1>");
	}

}
