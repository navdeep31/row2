package com.bae.oc.managers.offline;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.Product;
import com.bae.oc.managers.CustomerManager;
import com.bae.oc.util.TestData;

@Stateless
@Default
public class CustomerManagerOffline implements CustomerManager {
	

@Inject
private TestData testData;

@Override
public void createNewCustomer(Customer customer) {
List <Customer> customers = testData.getCustomers();
customer.setId(customers.size()+1);
customers.add(customer);
testData.setCustomers(customers);

}

@Override
public Customer findByEmail(String email) {
for(Customer customer : testData.getCustomers())
if(customer.getEmail().equalsIgnoreCase(email))
return customer;
return null;
}

@Override
public void updateCustomer(Customer customer){
	for(Customer customers : testData.getCustomers())
		if(customers.getId() == customer.getId())
			customers = customer;	
}

@Override
public void addToWishList(Product product, Customer customer){
		customer.getWishlist().add(product);

}

@Override
public void removeFromWishList(Product product, Customer customer){
	customer.getWishlist().remove(product);
}

@Override
public Customer orderBySurname(String lastname) {
	for(Customer customer : testData.getCustomers())
		if(customer.getLastname().equalsIgnoreCase(lastname))
			return customer;
	return null;
}

@Override
public Customer orderByDate(LocalDate dateAdded) {
	// TODO 
	for(Customer customer : testData.getCustomers())
		if(customer.getDateAdded().equals(dateAdded))
			return customer;
	return null;
}
}