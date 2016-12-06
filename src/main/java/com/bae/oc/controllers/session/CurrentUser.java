package com.bae.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.oc.entities.Customer;

/**
 * Stores customer information for session
 * 
 * @author Andrew Claybrook
 * @author Alex Dawson
 * @version 0.2 06/12/2016
 *
 */
@Named("user")
@SessionScoped
public class CurrentUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8724888548903959495L;
	private Customer customer = null;

	/**
	 * Checks whether a customer is currently logged in
	 * 
	 * @return A boolean of whether a customer is currently logged in
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Alex Dawson
	 */
	public boolean isLoggedIn() {
		return (customer == null) ? false : true;
	}

	/**
	 * Returns Customer of Current User
	 * 
	 * @return Customer
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Alex Dawson
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets Current User Customer
	 * 
	 * @param iCustomer Customer
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Alex Dawson
	 */
	public void setCustomer(Customer iCustomer) {
		this.customer = iCustomer;
	}
}
