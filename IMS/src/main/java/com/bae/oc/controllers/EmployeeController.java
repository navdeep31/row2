package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.EmployeeService;

/**
 * 
 * @author Tim Spencer
 *
 */

@RequestScoped
@Named("employee")
public class EmployeeController {
	
	@Inject
	CurrentUser currentUser;
	@Inject
	EmployeeService employeeService; 
	
	String name;
	String email;
	String password;
	
	/**
	 * Updates customer's password. 
	 * @MethodAuthor Tim Spencer
	 * @return
	 */
	public String update() {
		
		return null;
	}

	/**
	 * Gets employee's password for display. 
	 * @MethodAuthor Tim Spencer
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets customer's password as entered to be used in update method. 
	 * @MethodAuthor Tim Spencer
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets employee's name for display. 
	 * @MethodAuthor Tim Spencer
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets employee's email for display. 
	 * @MethodAuthor Tim Spencer
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	
	
}
