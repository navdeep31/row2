package jar;

import java.util.*;
import javax.inject.Inject;

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
	public void createCustomerOrder(Customer iCustomer, CustomerOrder iOrder)
	{
		List<CustomerOrder> customerOrders = iCustomer.getOrders();
		customerOrders.add(iOrder);
	}
	
	@Override
	public void updateCustomerOrder(Customer iCustomer, CustomerOrder iOrder)
	{
		List<CustomerOrder> orders = iCustomer.getOrders();
		for(CustomerOrder order : orders)
		{
			if (order.getId() == iOrder.getId())
			{
				order = iOrder;
			}
		}
		
		//TODO Raise exception if Customer Order (with ID) doesn't exist?
	}
	
	@Override
	public void updateOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
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
	public void addOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		orderLines.add(iOrderLine);
	}
	
	@Override
	public void removeOrderLine(CustomerOrder iOrder, CustomerOrderLine iOrderLine)
	{
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		orderLines.remove(iOrderLine);
	}

}
