package app;

import java.time.LocalDate;
import java.util.List;

import dao.PersonPassDao;
import entity.Passport;
import entity.Person;

public class PersonPassMain {

	public static void main(String[] args) {
		
		PersonPassDao dao = new PersonPassDao();
		/*
		Person p = new Person();
		p.setName("Aniket");
		p.setEmail("aniket22@gmail.com");
		p.setDob(LocalDate.of(1999, 10, 23));
		
		Passport ps = new Passport();
		ps.setIssueDate(LocalDate.of(2022, 10, 23));
		ps.setExpiryDate(LocalDate.of(2023, 10, 23));
		ps.setIssuedBy("Govt. of India");
		*/
		/*
		Person p = new Person();
		p.setName("SRK");
		p.setEmail("SRK@gmail.com");
		p.setDob(LocalDate.of(1965, 11, 2));
		
		Passport ps = new Passport();
		ps.setIssueDate(LocalDate.of(2000, 10, 23));
		ps.setExpiryDate(LocalDate.of(2020, 10, 23));
		ps.setIssuedBy("Gov. of America");
		
		p.setPassport(ps);	//setted passport ps to person p
		ps.setPerson(p);	//setted person p to passport p
		
		dao.add(p);			//addedd both the data into the table
		*/
		
		/*
		Person p = dao.fetchPersonByName("SRK");
		System.out.println(p.getName()+" "+p.getEmail());
		*/
		/*
		Person p = dao.fetchPersonByPassportNo(1);
		System.out.println(p.getName()+" "+p.getEmail());
		*/
		
		List<Person> list = dao.fetchPersByPassExpDateYr(2023);
		for(Person li : list) {
			System.out.println(li.getName()+" "+li.getEmail());
		}
		
		
	}

}
