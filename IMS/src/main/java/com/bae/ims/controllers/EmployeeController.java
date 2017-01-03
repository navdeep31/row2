package com.bae.ims.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.ims.controllers.session.CurrentUser;
import com.bae.ims.services.EmployeeService;

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
	
	String name = "";
	String email = "";
	String password = "";
	
	/**
	 * Updates customer's password. 
	 * @MethodAuthor Tim Spencer
	 * @return(
	 */
	public String update() {
		
		if(currentUser.isLoggedIn()) {
			try {
			currentUser.setEmployee(employeeService.update(currentUser.getEmployee(), password));
			return "homepage";
			} catch (NullPointerException e)  {
				System.out.println("User put wrong password in");
			}
		}				
		
		return null;
	}

	/**
	 * Gets employee's password for display. 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
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
	 * @MethodAuthor Alex Dawson
	 * @return
	 */
	public String getName() {
		
		if(this.name.isEmpty()) {
			this.name = currentUser.getEmployee().getName();
		}
		
		return name;
	}
	
	public void setName(String iName) {
		this.name = iName;
	}

	/**
	 * Gets employee's email for display. 
	 * @MethodAuthor Alex Dawson
	 * @return
	 */
	public String getEmail() {
		
		if(this.email.isEmpty()) {
			this.email = currentUser.getEmployee().getEmail();
		}
		
		return email;
	}
	
	public void setEmail(String iEmail) {
		this.email = iEmail;
	}
	
	

	
	
}
