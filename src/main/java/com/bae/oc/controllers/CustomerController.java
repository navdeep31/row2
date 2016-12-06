package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.CustomerService;

/**
 * Controller handling the editing of customer details
 * 
 * @author Administrator
 *
 */
@Named("customer")
@RequestScoped
public class CustomerController {
	
	@Inject
	private CustomerService customerService;
	@Inject
	private CurrentUser currentUser;
	
	private String firstName = "";
	private String lastName = "";
	private String password = "";
	private String email = "";
	private String line1 = "";
	private String line2 = "";
	private String postcode = "";
	private String city = "";
	
	/**
	 * Updates Customer Detail edits (on press of "update" button)
	 * 
	 * @return String of next page to visit
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String updateCustomer() {
		//TODO Check not all elements are empty? / raise exception
		currentUser.setCustomer(customerService.updateCustomer(currentUser.getCustomer(), firstName, lastName, password, email, line1, line2, postcode, city) );
		//TODO Check page name
		return "customer-edit";
	}
	
	
}
