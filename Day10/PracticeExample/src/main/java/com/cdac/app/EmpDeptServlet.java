package com.cdac.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Department;
import com.cdac.entity.Employee;


public class EmpDeptServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Employee e = new Employee();
			e.setEmpno(Integer.parseInt(request.getParameter("empno")));
			e.setName(request.getParameter("name"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setDoj(LocalDate.parse(request.getParameter("doj")));
			
			Department d = new Department();
			d.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			d.setName(request.getParameter("dname"));
			d.setLocation(request.getParameter("location"));
//			d.setEmployee((List<Employee>) e);
			
			e.setDept(d);
			
			GenericDao gd = new GenericDao();
			
			//add
			if(request.getParameter("button").equals("add")) {
				gd.save(e);
				out.write("<h1>Record Added Successfully</h1>");
			}
				
			//delete
//			if(request.getParameter("button").equals("delete"))
//				gd.delete(e);
			
			//select by deptno
			if(request.getParameter("button").equals("fetchDetailsByDeptno")) {
				List<Employee> list = gd.fetchEmpByDeptno(e.getEmpno());
				for(Employee emp : list)
				System.out.println(emp.getName()+"==>"+emp.getSalary());
				out.write("<h1>Record fetched Successfully</h1>");
			}
			
			//select by deptname
			if(request.getParameter("button").equals("fetchDetailsByDeptname")) {
				List<Employee> list1 = gd.fetchEmpByDeptname(d.getName());
				for(Employee emp1 : list1)
				System.out.println(emp1.getName()+"==>"+emp1.getSalary());
				out.write("<h1>Record fetched Successfully</h1>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

/*
Hibernate: create table dept (deptno integer not null auto_increment, location varchar(255), name varchar(255), primary key (deptno)) engine=InnoDB
Hibernate: create table emp (empno integer not null auto_increment, doj date, name varchar(255), salary double precision not null, deptno integer, primary key (empno)) engine=InnoDB
Hibernate: alter table emp add constraint FKfqt0j25nlvjwt7qt1t3x7v6qf foreign key (deptno) references dept (deptno)
*/
/*
Hibernate: select employee0_.empno as empno1_1_1_, employee0_.deptno as deptno5_1_1_, employee0_.doj as doj2_1_1_, employee0_.name as name3_1_1_, employee0_.salary as salary4_1_1_, department1_.deptno as deptno1_0_0_, department1_.location as location2_0_0_, department1_.name as name3_0_0_ from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno where employee0_.empno=?
Hibernate: select department0_.deptno as deptno1_0_0_, department0_.location as location2_0_0_, department0_.name as name3_0_0_ from dept department0_ where department0_.deptno=?
Hibernate: insert into dept (location, name) values (?, ?)
Hibernate: insert into emp (deptno, doj, name, salary) values (?, ?, ?, ?)
*/