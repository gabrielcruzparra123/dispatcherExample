/**
 * 
 */
package dispatcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dispatcher.bean.Customer;
import org.dispatcher.bean.Employee;
import org.dispatcher.bean.Person;
import org.dispatcher.framework.inter.IDispatcher;
import org.dispatcher.impl.Dispatcher;
import org.junit.Test;

/**
 * @author gabriel.cruz
 *
 */
public class DispatcherTest {
		
	@Test
	public void test1() {
		try {
		
			this.loadEmployees();
		
			Customer customer = new Customer(1L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("JOHANN","BARRERA","SANCHEZ","80796901",new Date()));
			Dispatcher.getInstance().setOnlineCustomer(customer);
			int expectedResult = 1;
			boolean resultBoolean = Dispatcher.getInstance().dispatchCall();
			int result = 0;
			if (resultBoolean) {
				result= 1;
			}
			assertEquals(expectedResult, result, 1);
			
			
		
		}catch(Exception e) {
			fail("Error: "+e.getMessage());
		}
	}
	
	
	@Test
	public void test2() {
		try {
		this.loadEmployees();
		Customer customer = new Customer(2L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("JULIETH","SARMIENTO","PALACIO","80796902",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean = Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	@Test
	public void test3() {
		try {
		this.loadEmployees();
		
		Customer customer = new Customer(3L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("CINDY","AVILA","CRUZ","80796903",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	@Test
	public void test4() {
		try {
		this.loadEmployees();
		
		Customer customer = new Customer(4L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("VIVIANA","LEGUIZAMON","MONROY","80796904",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	@Test
	public void test5() {
		try {
		this.loadEmployees();
		
		
		Customer customer = new Customer(5L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("HELENA","PERILLA","PEDRAZA","80796905",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int expectedResult = 1;
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	@Test
	public void test6() {
		try {
		this.loadEmployees();
		Customer customer = new Customer(6L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("OLGA","SARMIENTO","CACERES","80796906",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	@Test
	public void test7() {
		try {
		this.loadEmployees();

		Customer customer = new Customer(7L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("MICHAEL","COTRINA","CASTRO","80796907",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	

	@Test
	public void test8() {
		try {
		this.loadEmployees();

		Customer customer = new Customer(8L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("WILLIAM","RICO","ROJAS","80796908",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	

	@Test
	public void test9() {
		try {
		this.loadEmployees();
		
		Customer customer = new Customer(9L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("ANDREY","FIGUEROA","FERNANDEZ","80796909",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		int expectedResult = 1;
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	
	@Test
	public void test10() {
		try {
		this.loadEmployees();
		
		Customer customer = new Customer(10L, IDispatcher.CUSTOMER_STATE_ACTIVE, IDispatcher.CUSTOMER_NATURAL_TYPE,new Person ("CARLOS ALBERTO","CLAVIJO","ACEVEDO","80796910",new Date()));
		Dispatcher.getInstance().setOnlineCustomer(customer);
		boolean resultBoolean =Dispatcher.getInstance().dispatchCall();
		int expectedResult = 1;
		int result = 0;
		if (resultBoolean) {
			result= 1;
		}
		assertEquals(expectedResult, result, 1);
	}catch(Exception e) {
		fail("Error: "+e.getMessage());
	}
	}
	
	
	public void loadEmployees() {
		List<Employee> generalEmployees = new ArrayList<Employee>();
		generalEmployees.add(new Employee(1L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 1800000d, new Person ("GABRIEL","RODRIGUEZ","PEREZ","80794902",new Date())));
		generalEmployees.add(new Employee(2L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 2000000d, new Person ("JUAN","RODRIGUEZ","PEREZ","80794903",new Date())));
		generalEmployees.add(new Employee(3L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 1500000d, new Person ("MARINA","RODRIGUEZ","HERNANDEZ","80794801",new Date())));
		generalEmployees.add(new Employee(4L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 1000000d, new Person ("MARTHA","SIACHOQUE","REY","80794904",new Date())));
		generalEmployees.add(new Employee(5L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 2500000d, new Person ("RODRIGO","SARMIENTO","PALACIO","80794905",new Date())));
		generalEmployees.add(new Employee(6L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 2300000d, new Person ("CARLOS","GARCÍA","ORDOÑEZ","80794906",new Date())));
		generalEmployees.add(new Employee(7L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 2200000d, new Person ("ALEJANDRO","CRUZ","OSPINA","80794907",new Date())));
		generalEmployees.add(new Employee(8L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 2100000d, new Person ("PEDRO","MEJIA","ARMENDIA","80794908",new Date())));
		generalEmployees.add(new Employee(9L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR, 1900000d, new Person ("MATEO","LARROTA","PAEZ","80794909",new Date())));
		generalEmployees.add(new Employee(10L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_OPERATOR,1700000d, new Person ("LAURA","TORRES","TORO","80794910",new Date())));
		
		generalEmployees.add(new Employee(11L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_SUPERVISOR, 5000000d, new Person ("JOSE","JAIMES","ORDOÑEZ","80795901",new Date())));
		generalEmployees.add(new Employee(12L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_SUPERVISOR, 5500000d, new Person ("RENAN","RODRIGUEZ","OSPINA","80795902",new Date())));
		generalEmployees.add(new Employee(13L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_SUPERVISOR, 5600000d, new Person ("ANTONIO","SUSPES","ARMENDIA","80795903",new Date())));
		generalEmployees.add(new Employee(14L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_SUPERVISOR, 5700000d, new Person ("ALDO","HERNANDEZ","PAEZ","80795904",new Date())));
		generalEmployees.add(new Employee(15L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_SUPERVISOR,5800000d, new Person ("SANDRA","PERILLA","MONROY","80795905",new Date())));
		
		generalEmployees.add(new Employee(16L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_DIRECTOR, 7000000d, new Person ("SONIA","FAJARDO","OSPINA","80795901",new Date())));
		generalEmployees.add(new Employee(17L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_DIRECTOR, 7500000d, new Person ("LINA","URIBE","HERNANDEZ","80795902",new Date())));
		generalEmployees.add(new Employee(18L, IDispatcher.STATE_AVAILABLE, IDispatcher.EMPLOYEE_POSITION_DIRECTOR, 7600000d, new Person ("LUIS FERNANDO","ARAGON","ALCANTARA","80795903",new Date())));
		
		List<Employee> operators = new ArrayList<Employee>();
		List<Employee> supervisors = new ArrayList<Employee>();
		List<Employee> directors = new ArrayList<Employee>();
		
		for (Employee employee: generalEmployees) {
			if(employee.getPosition().equalsIgnoreCase(IDispatcher.EMPLOYEE_POSITION_OPERATOR)) {
				operators.add(employee);
			}else if (employee.getPosition().equalsIgnoreCase(IDispatcher.EMPLOYEE_POSITION_SUPERVISOR)) {
				supervisors.add(employee);
			}else {
				directors.add(employee);
			}
		}
		
		Dispatcher.getInstance().setOperators(operators);
		Dispatcher.getInstance().setSupervisors(supervisors);
		Dispatcher.getInstance().setDirectors(directors);
		
	}
	
	public static void main(String[] args) {
		
	}

}
