package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Album;
import entity.Song;

public class GenericDao {
	
	public void save(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.merge(obj);	//merge will act as both insert and update queries...
			
			tx.commit();
		}
		finally {
			emf.close();
		}
	}
	
	public Object fetchById(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			
			//find method generates select query where pk = ?
			Object obj = em.find(clazz, pk);	//className,id
			return obj;
		}
		finally {
			emf.close();
		}
	}

	public void delete(Class clazz,Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			//first find out the particular song/album and then delete it
			//find method generates select query where pk = ?
			Object obj = em.find(clazz, pk);	//className,id
			
			em.remove(obj); 	//remove will generate delete query
			//delete from Song where id=?
			
			tx.commit();
		}
		finally {
			emf.close();
		}
	}
	
}
