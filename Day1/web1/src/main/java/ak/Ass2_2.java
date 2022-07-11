package ak;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ass2_2")
public class Ass2_2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String DOB = request.getParameter("DOB");
		
		String[] str = DOB.split("-");
		
		String s1 = str[0];
		String s2 = str[1];
		String s3 = str[2];
		
		int day = Integer.parseInt(s1);
		int month = Integer.parseInt(s2);
		int year = Integer.parseInt(s3);
		
		LocalDate dob = LocalDate.of(year, month, day);
		
		LocalDate today = LocalDate.now();
		
		int years = Period.between(dob,today).getYears();
		int months = Period.between(dob,today).getMonths();
		int days = Period.between(dob,today).getDays();
				
		if(request.getParameter("b1") != null) {
			out.write("<h1>Age calculator Version_2</h1>");
			out.write("<h1>"+years+" years "+months+" Months "+days+" Days "+" Old</h1>");
		}

	}

}
