package org.dispatcher.framework.inter;

public interface IDispatcher {

	public static int MAXIMUM_CONCURRENT_CALLINGS = 10;
	public static String STATE_BUSY ="BUSY";
	public static String STATE_AVAILABLE ="AVAILABLE";
	public static String STATE_CALLING_ONLINE="ONLINE";
	public static String STATE_CALLING_OUTLINE="OUTLINE";
	
	public boolean dispatchCalling();
	
}
