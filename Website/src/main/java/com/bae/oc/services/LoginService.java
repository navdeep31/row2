package com.bae.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.managers.CustomerManager;




/**
 * Login Service deals with the business logic for loggging
 * methods for validating the customer and retrieving the customer
 * 
 * @author Andrew Claybrook
 * @author Alex Dawson
 * @author Josh Stanley
 * @version 0.2 06/12/2016
 *
 */

@Stateless
public class LoginService {

	@Inject
	private CustomerManager customerManager;
	
	/**
	 * Checking if the login is valid/ exists from given email and password
	 * 
	 * @param email - customer email
	 * @param password - customer password
	 * @return True/false
	 * 
	 * @MethodAuthor Alex Dawson, Josh Stanley, Andy Claybrook
	 */
	public boolean validLogin(String email, String password){
		Customer customer = customerManager.findByEmail(email);
		
		// If customer is null maybe raise different exception to relay to user?
		// For now return false (invalid login)
		if (customer == null) {
			return false;
		}
		
		
		return (customer.getPassword().equals(password)) ? true : false;	
	}
	//TODO handle exception if email/ password not found
	
	/**
	 * Retrieves customer from given email using the Customer manager
	 * assumes the user exists and is valid 
	 *
	 * @param email
	 * @return Customern with given email
	 * @MethodAuthor Andy Claybrook, Alex Dawson, Josh Stanley
	 */
	
	public Customer loginUser(String email) {
		return customerManager.findByEmail(email);
	}
	
}
