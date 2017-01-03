package com.bae.ims.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.ims.entities.Employee;
import com.bae.ims.managers.EmployeeManager;
import com.bae.ims.util.TestData; 

/**
 * @author Unknown (original) 
 * @version 0.2
 * 
 * @author Tim Spencer (updated) 
 * @version 0.3
 * 
 */

@Stateless
@Default
public class EmployeeManagerOffline implements EmployeeManager {

	@Inject
	private TestData testData; 
	
	/**
	 * 
	 * Finds the employee through their id through testdata.
	 * 
	 * @MethodAuthor Tim Spencer (Updates) 
	 * @MethodAuthor Unknown (Original)
	 * @param Employee
	 */
	@Override
	public Employee findEmployeeById(long id) {
		for(Employee employee: testData.getEmployees()) {
			if(employee.getId()==id) {
				return employee; 
			}
		}
		return null;
	}

	/**
	 * 
	 * Updates employee by passing a new employee to test data and removing
	 * the original version. 
	 * 
	 * @MethodAuthor Tim Spencer
	 * @param Employee
	 */
	@Override
	public void updateEmployee(Employee employee) {
		for (Employee testemployee : testData.getEmployees()) {
			if(testemployee.getId()==employee.getId()) {
				List<Employee> employeeCopy = testData.getEmployees();
				employeeCopy.remove(testemployee);
				employeeCopy.add(employee);
				testData.setEmployees(employeeCopy);
				
			}
		}
		
	}

	/**
	 * 
	 * Finds the employee through their email in testdata.
	 * 
	 * @MethodAuthor Tim Spencer (Updates) 
	 * @MethodAuthor Unknown (Original)
	 * @param Employee
	 */
	@Override
	public Employee findEmployeeByEmail(String email) {
			for (Employee employee : testData.getEmployees()) {
				if(employee.getEmail().equals(email));
				return employee;
			}
		return null;
	}

}
