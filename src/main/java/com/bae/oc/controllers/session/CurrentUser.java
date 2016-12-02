package com.bae.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.oc.entities.Customer;

@SessionScoped
@Named(value="user")

public class CurrentUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4885675902227807135L;
	private Customer customer = null;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public boolean isLoggedIn(){
		return (customer == null) ? false : true;
	}


}
