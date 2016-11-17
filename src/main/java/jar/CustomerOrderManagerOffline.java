package jar;

import java.util.*;
import javax.inject.Inject;

import antlr.collections.List;

/**
 * 
 * @author Alex Dawson
 * @version 0.1 17/11/2016
 *
 */
public class CustomerOrderManagerOffline implements CustomerOrderManager{
	@Inject
	private TestData testData;
	
	@Override
	public void createCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder)
	{
		List<CustomerOrder> customerOrders = iCustomer.getCustomerOrders();
		customerOrders.add(iCustomerOrder);
	}
	
	@Override
	public void updateCustomerOrder(Customer iCustomer, CustomerOrder iCustomerOrder)
	{
		List<CustomerOrder> customerOrders = iCustomer.getCustomerOrders();
		for(CustomerOrder customerOrder : customerOrders)
		{
			if (customerOrder.getId() == iCustomerOrder.getId())
			{
				customerOrder = iCustomerOrder;
			}
		}
		
		//TODO Raise exception if Customer Order (with ID) doesn't exist?
	}
	
	@Override
	public void updateOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iCustomerOrder.getOrderLines();
		for(CustomerOrderLine orderLine : orderLines)
		{
			if(orderLine.getLineNumber() == iOrderLine.getLineNumber())
			{
				orderLine = iOrderLine;
			}
		}
		
		//TODO Raise exception if Customer Order Line (with number) doesn't exist?
		
	}
	
	@Override
	public void addOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iCustomerOrder.getOrderLines();
		orderLines.add(iOrderLine);
	}
	
	@Override
	public void removeOrderLine(CustomerOrder iCustomerOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iCustomerOrder.getOrderLines();
		orderLines.remove(iOrderLine);
	}

}
