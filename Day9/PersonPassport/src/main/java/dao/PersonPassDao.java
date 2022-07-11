package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Person;

public class PersonPassDao {
	
	public void add(Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(person);
		
		tx.commit();
		emf.close();
	}
	
	public Person fetchPersonByPassportNo(int passNo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Person p join p.passport ps where ps.passportno= :pass");
		q.setParameter("pass", passNo);
		Person p = (Person) q.getSingleResult();
		
		emf.close();
		return p;
	}
	public Person fetchPersonByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Person p where p.name= :n");
		q.setParameter("n", name);
		Person p = (Person) q.getSingleResult();
		
		emf.close();
		return p;
	}
	public List<Person> fetchPersByPassExpDateYr(int year){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Person p join p.passport ps where year(ps.expiryDate)= :yr");
//		Query q = em.createQuery("select p from Passport ps join ps.person p where year(ps.expiryDate)= :yr");
		q.setParameter("yr", year);
		List<Person> list = q.getResultList();
		
		emf.close();
		return list;
	}
}
