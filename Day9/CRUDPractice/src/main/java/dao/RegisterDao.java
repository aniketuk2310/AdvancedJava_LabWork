package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;

import entity.Register;

public class RegisterDao {
	
	public void registerAdd(Register obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(obj);
		
		tx.commit();
		
		emf.close();		
	}
	public void registerUpdate(Register obj) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(obj);
		
		tx.commit();
		
		emf.close();	
			
	}
	public void registerDelete(String username) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("delete from Register where username = :uname");
		q.setParameter("uname", username);
//		q.setParameter("pass", password);
		System.out.println("Record deleted1111111..!!");
		q.executeUpdate();
				
		emf.close();		
	}
}
