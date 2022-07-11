package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cust")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//making primary key and auto increment
	@Column(name = "cust_id")
	private int id;
	
	private String name;
	private String email;
	
	//NO NO NO NO NO NO
	//we will never keep the FK column as part of the class structure
	//private int addrId;
	
	@OneToOne
	@JoinColumn(name = "addr_id")	//foreign key
	private Address address;		//association(has-a)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}