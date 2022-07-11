package app;

import dao.CustomerAddressDao;
import entity.Address;
import entity.Customer;

public class AddCustomerAndAddress {

	public static void main(String[] args) {
		
		CustomerAddressDao dao = new CustomerAddressDao();
		
		Customer c = new Customer();
		c.setName("Aniket");
		c.setEmail("aniketuk2310@gmail.com");
		dao.add(c);
		
		Address a = new Address();
		a.setPincode(413102);
		a.setCity("Pune");
		a.setState("Maharashtra");
		dao.add(a);

	}

}
