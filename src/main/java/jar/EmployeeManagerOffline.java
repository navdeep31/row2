package jar;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject; 

@Stateless
@Default
public class EmployeeManagerOffline implements EmployeeManager {

	@Inject
	private TestData testData; 
	
	@Override
	public List<Employee> findEmployeeById(long id) {
		List<Employee> employeeList = new ArrayList<Employee>(); 
		for(Customer customer: testData.getCustomers()) {
			if(customer.getId()==id) {
				
			}
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
