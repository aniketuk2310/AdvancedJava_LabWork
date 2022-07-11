package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Address;
import entity.Customer;

public class CustomerAddressDao {
	//adding customer
	public void add(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(cust);
		
		tx.commit();
		emf.close();
	}
	//adding address
	public void add(Address addr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(addr);
		
		tx.commit();
		emf.close();
	}
}
