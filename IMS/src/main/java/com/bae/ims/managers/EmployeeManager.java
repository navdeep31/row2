package com.bae.ims.managers;

import java.util.List;

import com.bae.ims.entities.Employee;

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

