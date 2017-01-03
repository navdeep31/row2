package com.bae.ims.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.ims.entities.Employee;

/**
 * 
 * @author Administrator
 * @version 0.1
 *
 */
@SessionScoped
@Named("user")
public class CurrentUser implements Serializable{
	
	private static final long serialVersionUID = 7612467751166624662L;
	
	Employee employee = null;

	
	/**
	 * @MethodAuthor Tim Spencer
	 * @return boolean; 
	 * 
	 * Checks if the employee is logged in or not. 
	 */
	public boolean isLoggedIn() {
		return employee != null ? true : false; 
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get the current session bean employee
	 * @return Employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets the current session bean employee 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	} 
	
	

}
