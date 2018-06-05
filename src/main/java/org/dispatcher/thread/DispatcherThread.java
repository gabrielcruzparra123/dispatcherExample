package org.dispatcher.thread;

import org.apache.log4j.Logger;
import org.dispatcher.bean.Calling;
import org.dispatcher.framework.inter.IDispatcher;

/**
 * @author Gcruz
 *Clase encargada de gestionar un hilo de llamada
 */
public class DispatcherThread extends Thread {
	
	private Calling calling;
	protected static Logger log = Logger.getLogger(DispatcherThread.class);
	/**
	 * Método que se encarga de generar el ciclo de atención de llamada
	 * se detiene hasta que el estado de la llamada cambia a fuera de línea
	 */
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
	/**
	 * Método que se encarga de cambiar el estado de la llamada a fuera de línea
	 */
	public void hangCalling() {
		this.getCalling().setState(IDispatcher.STATE_CALLING_OUTLINE);
	}
	/**
	 * Método de arranque del hilo de la llamada
	 */
	public void run() {
		// TODO Auto-generated method stub
		this.attendCalling();
		
	}
	/**
	 * Método get para obtener la llamada activa.
	 * @return Calling (llamada activa en el hilo)
	 */
	public Calling getCalling() {
		return calling;
	}
	/**
	 * Método set para fijar la llamada activa en el hilo
	 * @param calling
	 */
	public void setCalling(Calling calling) {
		this.calling = calling;
	}

	
}
