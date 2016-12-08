package com.bae.oc.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.RegistrationService;


/**
 * 
 * @author Josh Stanley
 *
 */

@Named("register")
@RequestScoped
public class RegistrationController {
	
	//////////////////////////////////////////INJECTIONS////////////////////////////////////////////////////

	@Inject
	private RegistrationService registrationService;

	@Inject
	private CurrentUser currentUser;

	
	//////////////////////////////////////////ATTRIBUTES///////////////////////////////////////////////////
	
	/**
	 * These are temporary attributes not associated with the customer entity
	 * empty strings to begin rather than null because of the method checking whether it is empty or not
	 * 
	 */
	
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String line1 = "";
	private String line2 = "";
	private String postcode = "";
	private String city = "";

	//////////////////////////////////////////METHODS//////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * Method to allow the inputs of the user
	 * Can take in either line1 & line2 of the Address or can take in just line1
	 * 
	 * @return String of the next page to visit
	 * 
	 * @MethodAuthor Josh Stanley
	 */

	public String signUp() {

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !line1.isEmpty()
				&& !postcode.isEmpty() && !city.isEmpty()) {

			if (!line2.isEmpty()) {

				currentUser.setCustomer(registrationService.register(firstName, lastName, email, password, line1, line2,
						postcode, city));
			}

			else {
				currentUser.setCustomer(
						registrationService.register(firstName, lastName, email, password, line1, postcode, city));
			}
			
			// Go to registration confirmation page if form correctly registers
			return "registration-confirmation";

		}
		
		// Stay on registration page if form incomplete
		return "register";

		

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
