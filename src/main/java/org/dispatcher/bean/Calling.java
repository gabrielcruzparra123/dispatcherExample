package org.dispatcher.bean;

import java.util.Date;

public class Calling {

	private Long idCalling;
	private Date begin;
	private Date end;
	private Float duration;
	private Employee agent;
	private Customer customer;
	private String state;

	public Calling() {
		super();
	}

	public Calling(Long idCalling, Date begin, Date end, Float duration, Employee agent, Customer customer,
			String state) {
		super();
		this.idCalling = idCalling;
		this.begin = begin;
		this.end = end;
		this.duration = duration;
		this.agent = agent;
		this.customer = customer;
		this.state = state;
	}



	public Long getIdCalling() {
		return idCalling;
	}
	public void setIdCalling(Long idCalling) {
		this.idCalling = idCalling;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public Employee getAgent() {
		return agent;
	}
	public void setAgent(Employee agent) {
		this.agent = agent;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
