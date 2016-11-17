package jar;

import java.util.List;

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
	public List<Employee> findEmployeeById (long id);
	
	public void updateEmployee (Employee employee); 
}

