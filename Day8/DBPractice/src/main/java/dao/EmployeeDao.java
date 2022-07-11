package dao;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entity.Employee;

//Data Access Object
//classes which contain database related code
//are commonly referred to as Dao classes

public class EmployeeDao {
	//inserting data
	public void add(Employee emp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(emp);
		
		tx.commit();
		
		emf.close();
	}
	//selecting data
	public Employee fetch(int empno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		//select * from emp where empno = ?;
		Employee emp = em.find(Employee.class, empno);
		emf.close();
		
		return emp;
	}
	public List<Employee> fetchAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e");
		List<Employee> list = q.getResultList();
		
		emf.close();
		
		return list;
	}
	public List<Employee> fetchAllBySal(double salary){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e where e.salary >= :sal");
		q.setParameter("sal", salary);
		List<Employee> list = q.getResultList();
		
		emf.close();
		
		return list;
	}
	public List<String> fetchAllByName(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e.name from Employee e");
		
		List<String> list = q.getResultList();
		
		emf.close();
		
		return list;
	}
	public List<Object[]> fetchAllNamesAndSalaries(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e.name,e.salary from Employee e");
		
		List<Object[]> list = q.getResultList();
		
		emf.close();
		
		return list;
	}
}
