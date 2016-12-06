package com.bae.oc.services;

import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.managers.CustomerManager;

public class LoginService {

	@Inject
	private CustomerManager customerManager;
	
	public boolean validLogin(String email, String password){
		Customer customer = customerManager.findByEmail(email);
		return (customer.getPassword().equals(password)) ? true : false;
	}
	
	public Customer loginUser(String email) {
		return customerManager.findByEmail(email);
	}
	
}
