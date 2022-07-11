package app;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.EmployeeDao;
import entity.Employee;

public class CRUDEmployee {
	
	public static void main(String[] args) {
		
		/*
		Employee emp = new Employee();
		emp.setEmpno(102);
		emp.setName("Sneha");
		emp.setSalary(70000);
		emp.setDoj(LocalDate.of(2023,02,19));
		
		EmployeeDao ed = new EmployeeDao();
		ed.add(emp);
		*/
		
		//selecting data
		
		/*EmployeeDao dao =  new EmployeeDao();
		Employee emp = dao.fetch(102);
		System.out.println(emp.getEmpno()+" "+emp.getName()+" "+emp.getSalary()+" "+emp.getDoj());
		*/
		
		EmployeeDao dao =  new EmployeeDao();
		List<Employee> list = dao.fetchAll();
		for(Employee emp : list)
			System.out.println(emp.getEmpno()+" "+emp.getName()+" "+emp.getSalary()+" "+emp.getDoj());
		
		System.out.println("======================");
		
		List<Employee> list2 = dao.fetchAllBySal(80000);
		for(Employee emp : list2)
			System.out.println(emp.getEmpno()+" "+emp.getName()+" "+emp.getSalary()+" "+emp.getDoj());
		
		System.out.println("======================");
		
		List<String> list3 = dao.fetchAllByName();
		for(String name : list3)
			System.out.println(name);
		
		System.out.println("======================");
		
		List<Object[]> list4 = dao.fetchAllNamesAndSalaries();
		for(Object[] arr : list4)
			System.out.println(arr[0] + " " + arr[1]);
		
	}
	/*public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp = new Employee();
		emp.setEmpno(101);
		emp.setName("Aniket");
		emp.setSalary(80000);
		emp.setDoj(LocalDate.of(2022,10,23));
		em.persist(emp);
		
		tx.commit();
		
		emf.close();
	}*/
}
