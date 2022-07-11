package firstMaven;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class insertEmployee {

	public static void main(String[] args) {
		//During this step, the persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstHibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp = new Employee();
		emp.setEmpno(1);
		emp.setEmpname("Aniket");
		emp.setSalary(100000);
		emp.setDateOfJoining(LocalDate.of(2022, 10, 23));
		em.persist(emp);//persist method will generate/fire insert query
		
		tx.commit();
		
		emf.close();

	}
}

/*
Hibernate: create table emptable (empno integer not null, doj date, empname varchar(255), salary double precision, primary key (empno)) engine=InnoDB

Hibernate: insert into emptable (doj, empname, salary, empno) values (?, ?, ?, ?)
*/
