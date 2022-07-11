package com.cdac.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Employee;


public class EmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Employee e = new Employee();
			e.setEmpno(Integer.parseInt(request.getParameter("empno")));
			e.setName(request.getParameter("name"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setDoj(LocalDate.parse(request.getParameter("doj")));
			
			GenericDao gd = new GenericDao();
			if(request.getParameter("button").equals("add")) {
				gd.save(e);
				out.write("<h1>Emp. Record added Successfully</h1>");
			}
				
			if(request.getParameter("button").equals("delete")) {
				gd.delete(e);
				out.write("<h1>Emp. Record deleted Successfully</h1>");
			}		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
