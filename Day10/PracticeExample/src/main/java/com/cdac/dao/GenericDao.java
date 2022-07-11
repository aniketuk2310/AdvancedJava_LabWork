package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Employee;

public class GenericDao {
	
	public void save(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();			
		}finally {
			emf.close();
		}
	}
	
	public void delete(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(em.contains(obj) ? obj : em.merge(obj));	
			//for EmpDeptServlet==>
			//we cannot delete both the records in emp and dept table 
			//becoz there is another rows also in the emp table which are associated with the
			//dept table(dept table acts as a parent table here)(foreign key constraint)
			tx.commit();			
		}finally {
			emf.close();
		}
	}
	
	public List<Employee> fetchEmpByDeptno(int deptno){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select e from Employee e join e.department d where d.deptno= :no"); 
			//		aniket==>57552.0
			//		aasha==>4522.0
			
			q.setParameter("no", deptno);
			
			List<Employee> e = q.getResultList();
			
			return e;
		}finally {
			emf.close();
		}
	}
	
	public List<Employee> fetchEmpByDeptname(String deptname){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select e from Employee e join e.department d where d.name= :nm"); 
			//		aniket==>57552.0
			//		aasha==>4522.0
			
			q.setParameter("nm", deptname);
			
			List<Employee> e = q.getResultList();
			
			return e;
		}finally {
			emf.close();
		}
	}
}
