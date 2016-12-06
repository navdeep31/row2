package com.bae.oc.managers;

import java.time.LocalDate;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.Product;

/**
 * Interface specification for Customer Managers
 * 
 * @author Conor White
 * @author Alex Dawson
 * @version 0.2 06/12/2016
 *
 */
public interface CustomerManager {
	
	public Customer findByEmail(String email);
	
	public Customer findById(long Id);
	
	/**
	 * Creates new customer, adding it to data
	 * 
	 * Returns the newly added customer to streamline Service methods
	 * 
	 * @param customer Customer to create
	 * @return Created Customer
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Customer createNewCustomer(Customer customer);
	
	public Customer orderBySurname(String lastname);
	public Customer orderByDate(LocalDate dateAdded);
	public void updateCustomer(Customer customer);
	public void addToWishList(Product product, Customer customer);
	public void removeFromWishList(Product product, Customer customer);
}