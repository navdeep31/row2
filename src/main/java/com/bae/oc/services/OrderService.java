 package com.bae.oc.services;

import java.util.ArrayList;
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
import com.bae.oc.entities.CustomerOrderLine;
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
	
	/**
	 * Validate's information within the order prior to confirmation.
	 * Will change status of order
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 *  
	 */
	public void confirmOrder(long customerOrderId) {

		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		
		if(customerOrder.getOrderLines().size()!=0) {
			
			if(customerOrder.getCost() <= 10000.00) {
				
				if(customerOrder.getStatus().equals(Status.BASKET)) {
					
					for(CustomerOrderLine customerOrderLine: customerOrder.getOrderLines()) {
						customerOrderLine.setItemPrice(customerOrderLine.getProduct().getCurrentPrice());
						customerOrderLine.setStatus(Status.ORDER);
						//May need to get rid of above line if not needed
					}
					customerOrder.setStatus(Status.ORDER);
				}
				else {
					//TODO add exception
				}
			}
			else {
				//TODO add exception
			}
		}
		else {
			//TODO add exception
		}
	}
	
	/**
	 * 
	 * Checks if customer has an open basket. If they do, the open basket is returned.
	 * If not then a new empty basket is created for the customer and returned.
	 * 
	 * @param customer
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @return CustomerOrder
	 * 
	 */
	public CustomerOrder getBasket(long customerId) {
		CustomerOrder basket = null;
		Customer customer = customerManager.findById(customerId); 
		
		for(CustomerOrder custOrders : customer.getOrders())
		{
			if(custOrders.getStatus().equals(Status.BASKET))
			{
				basket = custOrders;
			}
		}
		
		if(basket == null)
		{
			basket = new CustomerOrder(new ArrayList<CustomerOrderLine>());
		}
		
	return basket;
	}
	
	/**
	 * 
	 * Matches and gets product object from ProductManager.
	 * Iterates through the Customer Order's Customer Order Line to check if the Product ID already exists within, if so an exception will be thrown.
	 * After iteration if boolean isAlreadyInBasket is proven to be still false then new Customer Order Line entry is created and added back to the Customer Order
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param productId
	 * 
	 */
	
	// Depending on how Product is built Product may change to just the product ID being passed as an argument.
	
	public void addToBasket (long customerOrderId, long productId){
		Product product = productManager.findProductByPId(productId);
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		boolean isAlreadyInBasket = false;
				
		for(CustomerOrderLine custOrderLine : customerOrder.getOrderLines())
		{
			if(custOrderLine.getProduct().getProductID() ==  productId)
			{
				isAlreadyInBasket = true;
				// TODO add Exception
			}
		}
		
		if(!isAlreadyInBasket)
		{

			customerOrder.getOrderLines().add(new CustomerOrderLine(customerOrder.getId(), product, 1));
		}
		
	}
	
	/**
	 * 
	 * Iterates through the Customer Order Line attached to the Customer Order that has being passed to check if the Product ID passed exists within the Customer Order Line
	 * If this check is successful this removes the Customer Order Line.
	 * If this check is not successful an exception is thrown
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param product
	 * 
	 */
	
	// Depending on how Product is built Product may change to just the product ID being passed as an argument.
	
	public void removeFromBasket(long customerOrderId, long productId){
		boolean isInBasket = false;
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		
		for(CustomerOrderLine custOrderLine : customerOrder.getOrderLines())
		{
			if(custOrderLine.getProduct().getProductID() ==  productId)
			{
				isInBasket = true;
				customerOrder.getOrderLines().remove(custOrderLine);
			}
		}
		
		if(!isInBasket){
			// TODO add Exception
		}
	}
	
	/**
	 * 
	 * Iterates through the Customer Order Line attached to the Customer Order that has being passed to check if the Product ID passed exists within the Customer Order Line
	 * If this check is successful this sets the quantity to the value that has been passed.
	 * If this check is not successful an exception is thrown
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param product
	 * 
	 */
	
	public void updateQuantity(long customerOrderId, long productId, int quantity){
		boolean isInBasket = false;
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		
		if(quantity <= 0){
			// TODO add Exception
		}
		
		for(CustomerOrderLine custOrderLine : customerOrder.getOrderLines())
		{
			if(custOrderLine.getProduct().getProductID() ==  productId)
			{
				isInBasket = true;
				custOrderLine.setQuantity(quantity);
				break;
			}
		}
		
		if(!isInBasket){
			
			// TODO add Exception
		}
		
	}
	
	/* When Customers & Addresses are finalised build create validation for addresses
	public boolean hasAddress(Customer customer){
		return false;
	} */
	
	/**
	 * 
	 * A blank List of type CustomerOrder is created to allow adding of Customer Order objects.
	 * The Customer Order objects attached to the Customer are then iterated through to check the status does not equal BASKET.
	 * If this check is successful an exception is thrown
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customer
	 * @param orderHistory
	 * 
	 */
	
	
	public List<CustomerOrder> getOrderHistory(long customerId) {
		List<CustomerOrder> orderHistory = new ArrayList<CustomerOrder>(); 
		Customer customer = customerManager.findById(customerId); 		
		
		for(CustomerOrder custOrders : customer.getOrders())
		{
			if(custOrders.getStatus() != Status.BASKET)
			{
				orderHistory.add(custOrders);
			}
		}
					
		if(customer.getOrders().size() == 0 || orderHistory.size() == 0)
		{
			// TODO add Exception
		}
		return orderHistory;
	}
		
}
