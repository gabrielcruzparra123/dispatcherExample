package org.dispatcher.framework.inter;

public interface IDispatcher {

	public static int MAXIMUM_CONCURRENT_CALLINGS = 10;
	public static String STATE_BUSY ="BUSY";
	public static String STATE_AVAILABLE ="AVAILABLE";
	public static String STATE_CALLING_ONLINE="ONLINE";
	public static String STATE_CALLING_OUTLINE="OUTLINE";
	public static String EMPLOYEE_POSITION_OPERATOR="OPERATOR";
	public static String EMPLOYEE_POSITION_SUPERVISOR="SUPERVISOR";
	public static String EMPLOYEE_POSITION_DIRECTOR="DIRECTOR";
	public static String CUSTOMER_STATE_INACTIVE ="CUSTOMER_INACTIVE";
	public static String CUSTOMER_STATE_ACTIVE ="CUSTOMER_ACTIVE";
	public static String CUSTOMER_CORPORATIVE_TYPE = "CORPORATIVE";
	public static String CUSTOMER_NATURAL_TYPE = "NATURAL";
	
	public boolean dispatchCall();
	
}
