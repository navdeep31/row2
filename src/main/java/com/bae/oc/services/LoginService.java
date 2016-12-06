package com.bae.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.managers.CustomerManager;




/**
 * @author Alex Dawson, Josh Stanley, Andy Claybrook
 *
 * Login Service deals with the business logic for loggging
 * methods for validating the customer and retrieving the customer
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
