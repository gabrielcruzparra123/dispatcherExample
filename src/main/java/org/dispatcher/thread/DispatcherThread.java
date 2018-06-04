package org.dispatcher.thread;

import org.apache.log4j.Logger;
import org.dispatcher.bean.Calling;
import org.dispatcher.framework.inter.IDispatcher;

public class DispatcherThread extends Thread {
	
	private Calling calling;
	protected static Logger log = Logger.getLogger(DispatcherThread.class);
	
	public void attendCalling() {
		try {
			while(this.getCalling().getState().equalsIgnoreCase(IDispatcher.STATE_CALLING_ONLINE)) 
			{
				log.info("Atendiendo llamada ... ");
				log.info("Id llamada ... "+this.getCalling().getIdCalling());
				log.info("Cliente: "+this.getCalling().getCustomer().getPerson().getName()+" "+
					this.getCalling().getCustomer().getPerson().getMiddleName()+" "+
					this.getCalling().getCustomer().getPerson().getLastName());
				log.info("Agente: "+this.getCalling().getAgent().getPerson().getName()+" "+
					this.getCalling().getAgent().getPerson().getMiddleName()+" "+
					this.getCalling().getAgent().getPerson().getLastName());
				Thread.sleep(10000);
			}
		} catch(Exception e) {
			log.error("Error en llamada: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void hangCalling() {
		this.getCalling().setState(IDispatcher.STATE_CALLING_OUTLINE);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.attendCalling();
		
	}

	public Calling getCalling() {
		return calling;
	}

	public void setCalling(Calling calling) {
		this.calling = calling;
	}

	
}
