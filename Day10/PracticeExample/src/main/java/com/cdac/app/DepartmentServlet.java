package com.cdac.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Department;


public class DepartmentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Department d = new Department();
			d.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			d.setName(request.getParameter("name"));
			d.setLocation(request.getParameter("location"));
			
			GenericDao gd = new GenericDao();
			gd.save(d);
			
			out.write("<h1>Dept. Record added Successfully</h1>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
