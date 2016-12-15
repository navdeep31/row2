package com.bae.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.oc.entities.PurchaseOrder;

/**
 * Stores Selected Order (selected order on order history page to view details and edit)
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
 *
 */
@Named("selectedOrder")
@SessionScoped
public class SelectedOrder implements Serializable {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	private static final long serialVersionUID = 4604194124385366184L;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private PurchaseOrder order = null;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Returns Selected (Purchase) Order
	 * 
	 * @return Selected (Purchase) Order
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrder getOrder() {
		return this.order;
	}
	
	/**
	 * Sets Selected (Purchase) Order
	 * 
	 * @param iOrder Selected (Purchase) Order to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setOrder(PurchaseOrder iOrder) {
		this.order = iOrder;
	}

}
