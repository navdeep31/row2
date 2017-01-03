package com.bae.ims.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.ims.entities.Employee;
import com.bae.ims.managers.EmployeeManager;

/**
 * 
 * @author Tim Spencer
 *
 */
@Stateless
public class LoginService {
	@Inject
	EmployeeManager employeeManager;
	
	/**
	 * 
	 * Checks if employee entered correct email and password. 
	 * If they do, return the employee to be logged in.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	
	public Employee loginEmployee(String email, String password) {
		
	Employee employee = employeeManager.findEmployeeByEmail(email);
	
	if(employee != null && employee.getPassword_hash().equals(password)) {
		return employee; 
	} 
	
	return null;
	
	}
	
}
