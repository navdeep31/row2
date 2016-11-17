package com.bae.oc.managers;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;

/**
 * 
 * 
 * @author Alex Dawson
 * @version 0.1 17/11/2016
 *
 */
public interface CustomerOrderManager {
	
	void createCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder);
	
	void updateCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder);
	
	//////////////////////////////POSSIBLY OPTIONAL/////////////////////////////////////////
	
	//TODO Possibly need to be refactored depending on how Hibernate commands are implemented
	
	void updateOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	void addOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	void removeOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);

}
