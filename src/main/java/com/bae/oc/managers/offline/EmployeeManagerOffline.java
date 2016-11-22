package com.bae.oc.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Employee;
import com.bae.oc.managers.EmployeeManager;
import com.bae.oc.util.TestData; 

@Stateless
@Default
public class EmployeeManagerOffline implements EmployeeManager {

	@Inject
	private TestData testData; 
	
	@Override
	public Employee findEmployeeById(long id) {
		List<Employee> employeeList = new ArrayList<Employee>(); 
		for(Employee employee: testData.getEmployees()) {
			if(employee.getId()==id) {
				return employee; 
			}
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		for (Employee testemployee : testData.getEmployees()) {
			if(testemployee.getPassword_hash().equals(employee.getPassword_hash())) {
				
			}
		}
		
	}

}