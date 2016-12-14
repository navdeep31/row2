package com.bae.oc.managers;

import java.util.List;

import com.bae.oc.entities.Employee;

/**
 * 
 * @author Tim Spencer
 *
 */

public interface EmployeeManager {
	
	/**
	 * 
	 * Method Stubs
	 */
	public Employee findEmployeeById (long id);
	
	public Employee findEmployeeByEmail (String email); 
	
	public void updateEmployee (Employee employee); 
}

