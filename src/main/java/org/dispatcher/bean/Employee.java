package org.dispatcher.bean;

public class Employee {

	private Long idEmployee;
	private String state;
	private String position;
	private Double salary;
	private Person person;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long idEmployee, String state, String position, Double salary, Person person) {
		super();
		this.idEmployee = idEmployee;
		this.state = state;
		this.position = position;
		this.salary = salary;
		this.person = person;
	}
	
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
