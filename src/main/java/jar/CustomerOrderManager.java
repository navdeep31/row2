package jar;

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
	
	void updateOrderLine(Customer iCustomer, CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	void addOrderLine(Customer iCustomer, CustomerOrder iCustomerOrder, CustomerOrderLine iCustomerOrderLine);
	
	void removeOrderLine(Customer iCustomer, CustomerOrder iCustomerOrder, int iCustomerOrderLineNumber);

}
