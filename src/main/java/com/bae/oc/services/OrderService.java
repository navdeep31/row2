package com.bae.oc.services;

import java.util.List;

import javax.ejb.Stateless;

/**
 * 
 * Service for the Order Lifecycle
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 * 
 * @version 0.1
 * 
 */

import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.Product;
import com.bae.oc.enums.Status;
import com.bae.oc.managers.CustomerManager;
import com.bae.oc.managers.CustomerOrderManager;
import com.bae.oc.managers.ProductManager;

@Stateless
public class OrderService {
	
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
	private ProductManager productManager;
	@Inject
	private ProductService productService;
	
	/**
	 * Validate's information within the order prior to confirmation.
	 * Will change status of order
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 *  
	 */
	public void confirmOrder(CustomerOrder customerOrder) {
	}
	
	/**
	 * 
	 * Checks if customer has an open basket. If they do the open basket is returned.
	 * If not then a new empty basket is created for the customer and returned.
	 * 
	 * @param customer
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @return CustomerOrder
	 * 
	 */
	public CustomerOrder getBasket(Customer customer) {
	return null;
	}
	
	/**
	 * 
	 * Uses getBasket method to get current Basket of a customer.
	 * Adds a new CustomerOrderLine to the basket.
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param product
	 * 
	 */
	
	// Depending on how Product is built Product may change to just the product ID being passed as an argument.
	
	public void addToBasket(CustomerOrder customerOrder, Product product){
	}
	
	/**
	 * 
	 * Uses getBasket method to get current Basket of a customer.
	 * Removes a CustomerOrderLine from the basket.
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param product
	 * 
	 */
	
	// Depending on how Product is built Product may change to just the product ID being passed as an argument.
	
	public void removeFromBasket(CustomerOrder customerOrder, Product product){
	}
	
	/**
	 * 
	 * Uses getBasket method to get current Basket of a customer.
	 * Updates quantity field within a CustomerOrderLine
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * 
	 */
	
	public void updateQuantity(CustomerOrder customerOrder){
		
	}
	
	/* When Customers & Addresses are finalised build create validation for addresses
	public boolean hasAddress(Customer customer){
		return false;
	} */
	
	public List<CustomerOrder> getOrderHistory(Customer customer) throws NullPointerException {
		return null;
	}
	
}
