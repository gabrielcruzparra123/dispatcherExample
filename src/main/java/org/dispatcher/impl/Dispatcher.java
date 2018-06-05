package org.dispatcher.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dispatcher.bean.Calling;
import org.dispatcher.bean.Customer;
import org.dispatcher.bean.Employee;
import org.dispatcher.framework.inter.IDispatcher;
import org.dispatcher.thread.DispatcherThread;

/**
 * @author Gcruz
 * Clase Dispatcher que implementa la interfaz IDispatcher
 * se encarga de la gestión de llamadas 
 */
public class Dispatcher implements IDispatcher{
	
	private List<Employee> operators;
	private List<Employee> supervisors;
	private List<Employee> directors;
	private Employee selectedEmployee;
	private int callingQuantity;
	private Customer onlineCustomer;
	private List<Customer> customers;
	private LinkedList<Customer> pendingCustomers;
	private List<DispatcherThread> callings;
	
	private static final Dispatcher dispatcher= new Dispatcher();
	protected static Logger log = Logger.getLogger(Dispatcher.class);

	
	private Dispatcher() {
		super();
	}
	/**
	 * Método que retorna la instancia Dispatcher 
	 * @return dispatcher
	 */
	public static Dispatcher getInstance(){
		return dispatcher;
	}
	/**
	 * Método que se encarga de fijar el empleado (agente) que atenderá la llamada
	 */
	public void selectEmployee() {
		
		List<Employee> operators = this.getOperators();
		Iterator<Employee> operatorsIterator = operators.iterator();
		while(operatorsIterator.hasNext()) {
			Employee employee = operatorsIterator.next();
			if (employee.getState().equalsIgnoreCase(IDispatcher.STATE_AVAILABLE)) {
				if(this.getSelectedEmployee()== null) {
					log.info("Available employee: "+employee.getPerson().getName()+" "+
							employee.getPerson().getMiddleName()+" "+
							employee.getPerson().getLastName()
							);
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
						log.info("Available employee: "+employee.getPerson().getName()+" "+
								employee.getPerson().getMiddleName()+" "+
								employee.getPerson().getLastName()
								);
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
						log.info("Available employee: "+employee.getPerson().getName()+" "+
								employee.getPerson().getMiddleName()+" "+
								employee.getPerson().getLastName()
								);
						this.setSelectedEmployee(employee);
					}
				}
			}
		}
		
	}
	
	/**
	 * Método que se encarga de despachar la llamada para el cliente solicitante
	 * @return boolean (ejecución exitosa)
	 */
	public boolean dispatchCall() {
		// TODO Auto-generated method stub
		
		this.selectEmployee();
		int quantity = this.getCallingQuantity();
		if(quantity<IDispatcher.MAXIMUM_CONCURRENT_CALLINGS) {
			if(this.getSelectedEmployee()!=null) {
				try {
					Calling calling = new Calling();
					calling.setCustomer(this.getOnlineCustomer());
					calling.setAgent(this.getSelectedEmployee());
					calling.setBegin(new Date());
					calling.setState(IDispatcher.STATE_CALLING_ONLINE);
					calling.setIdCalling(System.currentTimeMillis());
					this.setEmployeeBusy(this.getSelectedEmployee());
					DispatcherThread dispatcherThread = new DispatcherThread();
					dispatcherThread.setCalling(calling);
					if(this.getCallings()!=null) {
						this.getCallings().add(dispatcherThread);
					} else {
						List<DispatcherThread> callings = new ArrayList<DispatcherThread>();
						callings.add(dispatcherThread);
						this.setCallings(callings);
					}
					
					dispatcherThread.start();
					this.setCallingQuantity(this.getCallingQuantity()+1);
					this.freeSelectedEmployee();
				} catch(Exception e) {
					log.info("Error: "+e.getMessage());
					e.printStackTrace();
				}
			}else {
				this.getPendingCustomers().add(this.getOnlineCustomer());
			}	
		}else {
			this.getPendingCustomers().add(this.getOnlineCustomer());
		}
		
		return true;
	}

	/**
	 * Método que se encarga de cambiar el estado del agente (empleado) a ocupado.
	 * @param employee
	 */
	public void setEmployeeBusy(Employee employee) {
		
		List<Employee> operators = this.getOperators();
		Iterator<Employee> operatorsIterator = operators.iterator();
		while(operatorsIterator.hasNext()) {
			Employee employeeToEvaluate = operatorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee operator to set busy: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_BUSY);
			}
		}
		
		List<Employee> supervisors = this.getSupervisors();
		Iterator<Employee> supervisorsIterator = supervisors.iterator();
		while(supervisorsIterator.hasNext()) {
			Employee employeeToEvaluate = supervisorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee supervisor to set busy: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_BUSY);
			}
		}
		
		List<Employee> directors = this.getDirectors();
		Iterator<Employee> directorsIterator = directors.iterator();
		while(directorsIterator.hasNext()) {
			Employee employeeToEvaluate = directorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee director to set busy: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_BUSY);
			}
		}
	}
	
	/**
	 * Método encargado de liberar a un empleado (agente) luego de terminar la llamada
	 * @param employee
	 */
	public void setEmployeeAvailable(Employee employee) {
		
		List<Employee> operators = this.getOperators();
		Iterator<Employee> operatorsIterator = operators.iterator();
		while(operatorsIterator.hasNext()) {
			Employee employeeToEvaluate = operatorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee operator to set available: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_AVAILABLE);
			}
		}
		
		List<Employee> supervisors = this.getSupervisors();
		Iterator<Employee> supervisorsIterator = supervisors.iterator();
		while(supervisorsIterator.hasNext()) {
			Employee employeeToEvaluate = supervisorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee supervisor to set available: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_AVAILABLE);
			}
		}
		
		List<Employee> directors = this.getDirectors();
		Iterator<Employee> directorsIterator = directors.iterator();
		while(directorsIterator.hasNext()) {
			Employee employeeToEvaluate = directorsIterator.next();
			if (employee.getPerson().getIdNumber().equalsIgnoreCase(
					employeeToEvaluate.getPerson().getIdNumber())) {
						log.info("Employee director to set available: "+
								"Name: "+employeeToEvaluate.getPerson().getName()+" "+
								employeeToEvaluate.getPerson().getMiddleName()+" "+
								employeeToEvaluate.getPerson().getLastName()+" "+
								employeeToEvaluate.getPerson().getIdNumber());
					employeeToEvaluate.setState(IDispatcher.STATE_AVAILABLE);
			}
		}
	}
	
	/**
	 * Método que se encarga de colgar la llamada
	 * @param dispatcherThread
	 * @return boolean (ejecución exitosa)
	 */
	public boolean endCalling(DispatcherThread dispatcherThread) {
		
		try {
			Employee employee = dispatcherThread.getCalling().getAgent();
			this.setEmployeeAvailable(employee);
			dispatcherThread.hangCalling();
			if(this.getCallings()!=null) {
				if(this.getCallings().size()>0) {
					Iterator<DispatcherThread> iteratorCallings = this.getCallings().iterator();
					
					while(iteratorCallings.hasNext()) {
						DispatcherThread dispatcherT = iteratorCallings.next();
						if(dispatcherT.getCalling().getIdCalling() == 
							dispatcherThread.getCalling().getIdCalling()) {
							log.info("Call to remove: "+dispatcherThread.getCalling().getIdCalling());
							iteratorCallings.remove();
						}
					}
				}
			}	
		}catch(Exception e) {
			e.printStackTrace();
			log.info("error: "+e.getMessage());
		}
		
		return true;
	}

	/**
	 * Método que se encarga de liberar al agente seleccionado
	 * para gestionar una nueva llamada con otro agente disponible 
	 */
	public void freeSelectedEmployee() {
		this.setSelectedEmployee(null);
	}
	
	/**
	 * Método get de retorno del atributo onlineCustomer (objeto Customer)
	 * @return onlineCustomer (cliente solicitante del servicio)
	 */
	public Customer getOnlineCustomer() {
		return onlineCustomer;
	}

	/**
	 * Método set para fijar el cliente solicitante del servicio
	 * @param onlineCustomer
	 */
	public void setOnlineCustomer(Customer onlineCustomer) {
		this.onlineCustomer = onlineCustomer;
	}

	/**
	 * Método get que retorna el listado de clientes atendidos
	 * @return List<Customers> (listado de clientes atendidos)
	 */
	public List<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Método set para fijar el listado de clientes atendidos.
	 * @param customers
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * Método get que retorna el listado de operadores
	 * @return List<Employee> (listado de empleados operadores)
	 */
	public List<Employee> getOperators() {
		return operators;
	}

	/**
	 * Método set que fija el listado de operadores
	 * @param operators
	 */
	public void setOperators(List<Employee> operators) {
		this.operators = operators;
	}
	/**
	 * Método get que retorna el listado de supervisores
	 * @return List<Employee> (listado de empleados supervisores)
	 */
	public List<Employee> getSupervisors() {
		return supervisors;
	}
	/**
	 * Método set para fijar el listado de supervisores
	 * @param supervisors
	 */
	public void setSupervisors(List<Employee> supervisors) {
		this.supervisors = supervisors;
	}
	/**
	 * Método get que retorna el listado de directores
	 * @return List<Employee> (listado de directores)
	 */
	public List<Employee> getDirectors() {
		return directors;
	}
	/**
	 * Método set para fijar el listado de directores
	 * @param directors
	 */
	public void setDirectors(List<Employee> directors) {
		this.directors = directors;
	}
	/**
	 * Método get para obtener el agente (empleado) seleccionado 
	 * para atender la llamada.
	 * @return
	 */
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * Método set para fijar el agente (empleado) seleccionado
	 * para atender la llamada.
	 * @param selectedEmployee
	 */
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	/**
	 * Método get que retorna la cantidad de llamadas atendidas
	 * @return int (cantidad de llamadas)
	 */
	public int getCallingQuantity() {
		return callingQuantity;
	}
	/**
	 * Método set para fijar la cantidad de llamadas atendidas
	 * @param callingQuantity
	 */
	public void setCallingQuantity(int callingQuantity) {
		this.callingQuantity = callingQuantity;
	}
	/**
	 * Método get para obtener el listado de clientes pendientes de atender
	 * @return LinkedList<Customer> (clientes por atender)
	 */
	public LinkedList<Customer> getPendingCustomers() {
		return pendingCustomers;
	}
	/**
	 * Método set para fijar el listado de clientes pendientes por atender
	 * @param pendingCustomers
	 */
	public void setPendingCustomers(LinkedList<Customer> pendingCustomers) {
		this.pendingCustomers = pendingCustomers;
	}
	/**
	 * Método get para obtener el listado de llamadas en atención
	 * @return List<DispatchThread> (listado de llamadas en atención)
	 */
	public List<DispatcherThread> getCallings() {
		return callings;
	}
	/**
	 * Método set para fijar el listado de llamadas en atención
	 * @param callings
	 */
	public void setCallings(List<DispatcherThread> callings) {
		this.callings = callings;
	}

}
