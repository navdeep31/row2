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
public Customer updateCustomer(Customer customer){
	//TODO
	
	return customer;
	
}

@Override
public Customer addToWishList(Product id){
	//TODO
	
return null;

}

@Override
public Customer removeFromWishList(Product id){
	//TODO
	
return null;

}

@Override
public Customer orderBySurname(String lastname) {
	// TODO 
	return null;
}

@Override
public Customer orderByDate(LocalDate dateAdded) {
	// TODO 
	return null;
}
}
