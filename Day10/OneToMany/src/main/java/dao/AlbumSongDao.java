package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Song;

public class AlbumSongDao extends GenericDao {
	
	public List<Song> fetchSongsByArtist(String artist) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select s from Song s where s.artist= :artist");
			q.setParameter("artist", artist);
			
			List<Song> songs = q.getResultList();
			return songs;
		}
		finally {
			emf.close();
		}
	} 
	
	//using join
	public List<Song> fetchSongByCopyright(String copyRight){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learnHibernate");
		
		try {
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select s from Song s join s.album a where a.copyright= :cr");
			q.setParameter("cr", copyRight);
			
			List<Song> songs = q.getResultList();
			return songs;
		}
		finally {
			emf.close();
		}
	}
}
