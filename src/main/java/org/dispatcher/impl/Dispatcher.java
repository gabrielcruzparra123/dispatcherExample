package org.dispatcher.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.dispatcher.bean.Calling;
import org.dispatcher.bean.Customer;
import org.dispatcher.bean.Employee;
import org.dispatcher.framework.inter.IDispatcher;
import org.dispatcher.thread.DispatcherThread;

public class Dispatcher implements IDispatcher{
	
	private List<Employee> operators;
	private List<Employee> supervisors;
	private List<Employee> directors;
	private Employee selectedEmployee;
	private int callingQuantity;
	private Customer onlineCustomer;
	private List<Customer> customers;
	private LinkedList<Customer> pendingCustomers;
	private List<Calling> callings;
	
	private static final Dispatcher dispatcher= new Dispatcher();

	
	private Dispatcher() {
		super();
	}
	
	public static Dispatcher getInstance(){
		return dispatcher;
	}
	
	public boolean dispatchCall() {
		// TODO Auto-generated method stub
		
		List<Employee> operators = this.getOperators();
		Iterator<Employee> operatorsIterator = operators.iterator();
		while(operatorsIterator.hasNext()) {
			Employee employee = operatorsIterator.next();
			if (employee.getState().equalsIgnoreCase(IDispatcher.STATE_AVAILABLE)) {
				if(this.getSelectedEmployee()== null) {
					this.setSelectedEmployee(employee);
				}
			}
			
		}
		
		if(this.getSelectedEmployee()== null) {
			List<Employee> supervisors = this.getSupervisors();
			Iterator<Employee> supervisorsIterator = supervisors.iterator();
			while(supervisorsIterator.hasNext()) {
				Employee employee = supervisorsIterator.next();
				if (employee.getState().equalsIgnoreCase(IDispatcher.STATE_AVAILABLE)) {
					if(this.getSelectedEmployee()== null) {
						this.setSelectedEmployee(employee);
					}
				}
			}
		}
		
		if(this.getSelectedEmployee()==null) {
			List<Employee> directors = this.getDirectors();
			Iterator<Employee> directorsIterator = directors.iterator();
			while(directorsIterator.hasNext()) {
				Employee employee = directorsIterator.next();
				if (employee.getState().equalsIgnoreCase(IDispatcher.STATE_AVAILABLE)) {
					if(this.getSelectedEmployee()== null) {
						this.setSelectedEmployee(employee);
					}
				}
			}
		}
		
		int quantity = this.getCallingQuantity();
		if(quantity<IDispatcher.MAXIMUM_CONCURRENT_CALLINGS) {
			Calling calling = new Calling();
			calling.setCustomer(this.getOnlineCustomer());
			calling.setAgent(this.getSelectedEmployee());
			calling.setBegin(new Date());
			calling.setState(IDispatcher.STATE_CALLING_ONLINE);
			calling.setIdCalling(System.currentTimeMillis());
			this.setEmployeeBusy(this.getSelectedEmployee());
			DispatcherThread dispatcherThread = new DispatcherThread();
			dispatcherThread.setCalling(calling);
			dispatcherThread.run();
			this.setCallingQuantity(this.getCallingQuantity()+1);
		}else {
			this.getPendingCustomers().add(this.getOnlineCustomer());
		}
		
		return true;
	}

	public void setEmployeeBusy(Employee employee) {
		
		List<Employee> operators = this.getOperators();
		Iterator<Employee> operatorsIterator = operators.iterator();
		while(operatorsIterator.hasNext()) {
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(operatorsIterator.next().getPerson().getIdNumber())) {
					operatorsIterator.next().setState(IDispatcher.STATE_BUSY);
			}
		}
		
		List<Employee> supervisors = this.getSupervisors();
		Iterator<Employee> supervisorsIterator = supervisors.iterator();
		while(supervisorsIterator.hasNext()) {
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(supervisorsIterator.next().getPerson().getIdNumber())) {
				supervisorsIterator.next().setState(IDispatcher.STATE_BUSY);
			}
		}
		
		List<Employee> directors = this.getDirectors();
		Iterator<Employee> directorsIterator = directors.iterator();
		while(directorsIterator.hasNext()) {
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(directorsIterator.next().getPerson().getIdNumber())) {
				directorsIterator.next().setState(IDispatcher.STATE_BUSY);
			}
		}
	}
	
	public void freeSelectedEmployee() {
		this.setSelectedEmployee(null);
	}
	
	public Customer getOnlineCustomer() {
		return onlineCustomer;
	}

	public void setOnlineCustomer(Customer onlineCustomer) {
		this.onlineCustomer = onlineCustomer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public List<Employee> getOperators() {
		return operators;
	}


	public void setOperators(List<Employee> operators) {
		this.operators = operators;
	}
	
	public List<Employee> getSupervisors() {
		return supervisors;
	}
	
	public void setSupervisors(List<Employee> supervisors) {
		this.supervisors = supervisors;
	}

	public List<Employee> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Employee> directors) {
		this.directors = directors;
	}
	
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}


	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public int getCallingQuantity() {
		return callingQuantity;
	}

	public void setCallingQuantity(int callingQuantity) {
		this.callingQuantity = callingQuantity;
	}

	public LinkedList<Customer> getPendingCustomers() {
		return pendingCustomers;
	}

	public void setPendingCustomers(LinkedList<Customer> pendingCustomers) {
		this.pendingCustomers = pendingCustomers;
	}

	public List<Calling> getCallings() {
		return callings;
	}

	public void setCallings(List<Calling> callings) {
		this.callings = callings;
	}

}
