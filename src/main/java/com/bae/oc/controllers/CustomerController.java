package com.bae.oc.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.CustomerService;

/**
 * Controller handling the editing of customer details
 * 
 * @author Alex Dawson
 * @version 0.1 06/12/2016
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
	
	/**
	 * Fills CustomerController attributes with Current User values when loading My Account Details Page
	 * 
	 * @return String of next page to visit (My Account Details)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@PostConstruct
	public void getCustomerDetails() {
		if(currentUser != null) {
			this.firstName = currentUser.getCustomer().getFirstName();
			this.lastName = currentUser.getCustomer().getLastName();
			this.email = currentUser.getCustomer().getEmail();
			this.password = currentUser.getCustomer().getPassword();
			this.line1 = currentUser.getCustomer().getAddress().getLine1();
			this.line2 = currentUser.getCustomer().getAddress().getLine2();
			this.postcode = currentUser.getCustomer().getAddress().getPostcode();
			this.city = currentUser.getCustomer().getAddress().getCity();
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
