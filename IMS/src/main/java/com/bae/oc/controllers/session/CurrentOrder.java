package com.bae.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.oc.entities.PurchaseOrder;

/**
 * Stores Current Order (equivalent of basket) information for session
 * Current order persists for all users
 * When a current order is placed a new empty one is created
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
 *
 */
@Named("currentOrder")
@SessionScoped
public class CurrentOrder implements Serializable {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	private static final long serialVersionUID = 4604194124385366184L;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private PurchaseOrder order = null;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Returns Current (Purchase) Order
	 * 
	 * @return Current (Purchase) Order
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrder getOrder() {
		return this.order;
	}
	
	/**
	 * Sets Current (Purchase) Order
	 * 
	 * @param iOrder Current (Purchase) Order to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setOrder(PurchaseOrder iOrder) {
		this.order = iOrder;
	}
}
