package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	//updating customer table
	public void update(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.merge(cust);//merge method will generate update query
		
		tx.commit();
		emf.close();
	}
	
	//selecting row with a specific id from customer table
	public Customer fetchCust(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Customer emp = em.find(Customer.class, id);
		
		emf.close();
		return emp;
	}
	
	//selecting row with a email from customer table
	public List<Customer> fetchCustByEmail(String domain){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c where c.email like :em");
		
		q.setParameter("em", "%" + domain + "%");
		
		List<Customer> list = q.getResultList();
		
		emf.close();
		return list;
	}
	
	//selecting rows by name from customer table;
	public List<Customer> fetchCustByName(String name){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
//		Query q = em.createQuery("select c.name from Customer c where c.name= :nm");
		Query q = em.createQuery("select c from Customer c where c.name= :nm");
		q.setParameter("nm", name);
		
		List<Customer> list = q.getResultList();
		
		emf.close();
		return list;
	}
	//selecting customer by city (use of joins)
	public List<Customer> fetchCustByCity(String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c join c.address a where a.city = :ct");
		q.setParameter("ct", city);
		
		List<Customer> list = q.getResultList();
		
		emf.close();
		return list;
	}
	
	//=======================================================================================================
	
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
	//selecting by address
	public Address fetchAdd(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
		Address emp = em.find(Address.class, id);
		
		emf.close();
		return emp;
	}
	
	/*
	public List<Address> fetchCityByCust(String name){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secondHibernate");
		EntityManager em = emf.createEntityManager();
		
//		Query q = em.createQuery("select a from Address a join a.Customer c where a.name= : nm");
		Query q = em.createQuery("select a from Address a join Customer c where c.name= :nm");
		q.setParameter("nm", name);
		List<Address> list3 = q.getResultList();
		
		em.close();
		return list3;
	}
	
	select a.* from tbl_addr a
    -> inner join tbl_cust c
    -> on a.addr_id = c.addr_id
    -> where c.name = "Sneha";
+---------+--------+---------+-------------+
| addr_id | city   | pincode | state       |
+---------+--------+---------+-------------+
|       4 | Nashik |  413105 | Maharashtra |
+---------+--------+---------+-------------+
	*/
}
