package org.dispatcher.bean;

import java.util.Date;

public class Person {

	private String name;
	private String middleName;
	private String lastName;
	private String idNumber;
	private Date bornDate;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Person(String name, String middleName, String lastName, String idNumber, Date bornDate) {
		super();
		this.name = name;
		this.middleName = middleName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.bornDate = bornDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
	
}
