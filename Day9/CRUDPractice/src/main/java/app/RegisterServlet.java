package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import entity.Register;


public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out = response.getWriter();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			long mobno = Long.parseLong(request.getParameter("mobno"));
			String email = request.getParameter("email");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			
			String button = request.getParameter("button");
			
			Register rg = new Register();
			rg.setUsername(username);
			rg.setPassword(password);
			rg.setMobNo(mobno);
			rg.setEmail(email);
			rg.setDob(dob);
			
			RegisterDao dao = new RegisterDao();
			if(button.equals("Insert")) {
				dao.registerAdd(rg);
				out.write("<h1>Regiseter Successfull..!!!</h1>");
			}
			else if(button.equals("Update")) {
				dao.registerUpdate(rg);
				out.write("<h1>Update Successfull..!!!</h1>");
			}
				
			else if(button.equals("Delete")) {
				System.out.println("656");
				dao.registerDelete(username);
				out.write("<h1>Deletion Successfull..!!!</h1>");
			}
			
		}catch(Exception e) {
			out.write("<h1>Something went wrong..!!!</h1>");
		}
		
	}

}
