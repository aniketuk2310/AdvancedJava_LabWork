package app;

import java.util.List;

import dao.CustomerAddressDao;
import entity.Address;
import entity.Customer;

public class AddCustomerAndAddress {

	public static void main(String[] args) {
		
		CustomerAddressDao dao = new CustomerAddressDao();
		/*
		Customer c = new Customer();
		c.setName("Aniket");
		c.setEmail("aniketuk2310@gmail.com");
		dao.add(c);
		
		Address a = new Address();
		a.setPincode(413102);
		a.setCity("Pune");
		a.setState("Maharashtra");
		dao.add(a);
		 
		Customer c = dao.fetchCust(1);
		Address a = dao.fetchAdd(1);
		
		c.setAddress(a);
		dao.update(c);
		*/
		
		/*
		Customer c = new Customer();
		c.setName("Sneha");
		c.setEmail("snehaak1902@gmail.com");
		
		Address a = new Address();
		a.setPincode(413105);
		a.setCity("Nashik");
		a.setState("Maharashtra");
		
		c.setAddress(a);
		dao.update(c);
		*/
		
		/*
		Customer c = dao.fetchCust(1);
		System.out.println(c.getId()+" "+c.getName()+" "+c.getEmail()+" "+c.getAddress().getState());
			//1 Aniket aniketuk2310@gmail.com Maharashtra
		*/
		
		/*
		Customer c = new Customer();
		c.setName("Salman");
		c.setEmail("salman123@yahoo.com");
		
		Address a = new Address();
		a.setPincode(786);
		a.setCity("Mumbai");
		a.setState("Bihar");
		
		c.setAddress(a);
		dao.update(c);
		*/
		
		/*
//		List<Customer> list = dao.fetchCustByEmail("@gmail");
		List<Customer> list = dao.fetchCustByEmail("@yahoo");	//6 Salman salman123@yahoo.com Mumbai
		for(Customer show : list)
			System.out.println(show.getId()+" "+show.getName()+" "+show.getEmail()+" "+show.getAddress().getCity());
			//1 Aniket aniketuk2310@gmail.com Pune
			//5 Sneha snehaak1902@gmail.com Nashik
		*/
		
		/*
		List<Customer> list1 = dao.fetchCustByName("Aniket");
		for(Customer show : list1)
			System.out.println(show.getId()+" "+show.getName());
		*/	
		
		List<Customer> list2 = dao.fetchCustByCity("Pune");
		for(Customer show : list2)
			System.out.println(show.getName()+" "+show.getAddress().getCity()); 	//Aniket Pune
		
//		Address alist = dao.fetchAdd(1);
//		System.out.println(alist.getCity()+" "+alist.getState());
		
		
	}

}
