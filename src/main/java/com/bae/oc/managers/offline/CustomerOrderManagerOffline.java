package com.bae.oc.managers.offline;

import java.util.*;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;
import com.bae.oc.managers.CustomerOrderManager;
import com.bae.oc.util.TestData;

/**
 * Implements a Customer Order Manager with Test Data (without a database)
 * 
 * @author Alex Dawson
 * @version 0.2 22/11/2016
 *
 */
@Stateless
@Default
public class CustomerOrderManagerOffline implements CustomerOrderManager {
	@Inject
	private TestData testData;
	
	//TODO Remove test data if unnecessary?
	
	/**
	 * Creates a new Customer Order
	 * 
	 * @param iCustomer Customer to add an order to
	 * @param iCustomerOrder CustomerOrder
	 * 
	 * @MethodAuthor Alex Dawson
	 * 
	 * NOTE: Possible validation check needed for duplicate orders being 
	 * added in a service.
	 */
	@Override
	public void createCustomerOrder(Customer iCustomer, CustomerOrder iOrder) {
		List<CustomerOrder> customerOrders = iCustomer.getOrders();
		customerOrders.add(iOrder);
	}
	
	/**
	 * Updates a Customer Order
	 * 
	 * @param iCustomer Customer whose order needs updating
	 * @param iCustomerOrder Updated CustomerOrder
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public void updateCustomerOrder(Customer iCustomer, CustomerOrder iOrder) {
		List<CustomerOrder> orders = iCustomer.getOrders();
		for(CustomerOrder order : orders) {
			if (order.getId() == iOrder.getId()) {
				order = iOrder;
			}
		}
		
		//TODO Raise exception if Customer Order (with ID) doesn't exist?
	}
	
	/**
	 * Updates a Customer Order Line
	 * 
	 * @param iCustomerOrder CustomerOrder whose line needs updating
	 * @param iCustomerOrderLine Updated CustomerOrderLine
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public void updateOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine)	{
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		for(CustomerOrderLine orderLine : orderLines) {
			if(orderLine.getLineNumber() == iOrderLine.getLineNumber())	{
				orderLine = iOrderLine;
			}
		}
		
		//TODO Raise exception if Customer Order Line (with number) doesn't exist?
		
	}
	
	/**
	 * Adds a Customer Order Line
	 * 
	 * @param iCustomerOrder CustomerOrder to add a line to
	 * @param iCustomerOrderLine CustomerOrderLine to add
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public void addOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine) {
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		orderLines.add(iOrderLine);
	}
	
	/**
	 * Removes a Customer Order Line (by CustomerOrderLine object)
	 * 
	 * @param iCustomerOrder CustomerOrder to remove line from
	 * @param iCustomerOrderLine CustomerOrderLine to remove
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public void removeOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine)	{
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		orderLines.remove(iOrderLine);
	}

	@Override
	public CustomerOrder findByOrderId(long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
