package com.bae.ims.services;

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
public class EmployeeService {
	@Inject
	EmployeeManager employeeManager; 
	
	/**
	 * 
	 * Updates an employee's password (if it passes validation checks) 
	 * 
	 * @MethodAuthor Tim Spencer
	 * @param employee
	 * @param password
	 * @return Employee
	 */
	public Employee update(Employee employee, String password) {
		if(employeeManager.findEmployeeById(employee.getId())!=null) {
			employee.setPassword_hash(password);
			return employee; 
		} else {
			throw new NullPointerException(); 
		}
		
	}
}
