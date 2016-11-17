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
	
	public void updateEmployee (Employee employee); 
}

