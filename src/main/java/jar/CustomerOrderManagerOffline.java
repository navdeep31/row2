package jar;

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

}
