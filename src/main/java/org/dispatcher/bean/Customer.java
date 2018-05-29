package org.dispatcher.bean;

public class Customer {

	private Long idCustomer;
	private String state;
	private String customerType;
	private Person person;
	
	public Customer(Long idCustomer, String state, String customerType, Person person) {
		super();
		this.idCustomer = idCustomer;
		this.state = state;
		this.customerType = customerType;
		this.person = person;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
}
