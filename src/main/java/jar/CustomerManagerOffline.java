package jar;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Stateless
@Default
public class CustomerManagerOffline implements CustomerManager {
	

@Inject
private TestData testData;

@Override
public Customer createNewCustomer(Customer customer) {
List <Customer> customers = testData.getCustomers();
customer.setId(customers.size()+1);
customers.add(customer);
testData.setCustomers(customers);
return findByEmail(customer.getEmail());
}

@Override
public Customer findByEmail(String email) {
for(Customer customer : testData.getCustomers())
if(customer.getEmail().equalsIgnoreCase(email))
return customer;
return null;
}

@Override
public Customer orderBySurname(String lastname) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer orderByDate(LocalDate dateAdded) {
	// TODO Auto-generated method stub
	return null;
}
}
