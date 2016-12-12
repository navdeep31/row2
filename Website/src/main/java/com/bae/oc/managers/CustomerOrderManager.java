package com.bae.oc.managers;

import java.util.ArrayList;
import java.util.List;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;

/**
 * Interface Specification for Customer Order Managers
 * 
 * @author Alex Dawson
 * @version 0.2 22/11/2016
 *
 */
public interface CustomerOrderManager {
	
	/**
	 * Creates a new Customer Order
	 * 
	 * @param iCustomer Customer to add an order to
	 * @param iCustomerOrder CustomerOrder
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	void createCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder);
	
	/**
	 * Updates a Customer Order
	 * 
	 * @param iCustomer Customer whose order needs updating
	 * @param iCustomerOrder Updated CustomerOrder
	 * 
	 * @MethodAuthor Alex Dawson
	 */

	void updateCustomerOrder(CustomerOrder customerOrder); 
	
	void updateCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder);
	
	//////////////////////////////POSSIBLY OPTIONAL/////////////////////////////////////////
	
	//TODO Possibly need to be refactored depending on how Hibernate commands are implemented
	
	/**
	 * Updates a Customer Order Line
	 * 
	 * @param iCustomerOrder CustomerOrder whose line needs updating
	 * @param iCustomerOrderLine Updated CustomerOrderLine
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	void updateOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	/**
	 * Adds a Customer Order Line
	 * 
	 * @param iCustomerOrder CustomerOrder to add a line to
	 * @param iCustomerOrderLine CustomerOrderLine to add
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	void addOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	/**
	 * Removes a Customer Order Line (by CustomerOrderLine object)
	 * 
	 * @param iCustomerOrder CustomerOrder to remove line from
	 * @param iCustomerOrderLine CustomerOrderLine to remove
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	void removeOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	/**
	 * Find an order by it's id
	 * @param id
	 * @return
	 * @MethodAuthor Tim Spencer
	 */
	CustomerOrder findByOrderId(long id);

}
