package com.bae.oc.controllers;

import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.services.OrderService;

/**
 * Controller for the Order History
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 * @version 0.1 07/12/2016
 *
 */

@ConversationScoped
@Named("orderhistory")
public class OrderHistoryController {

	@Inject
	private OrderService orderService;
	@Inject
	private CurrentUser currentUser;
	private long orderId;
	
	/**
	 *
	 * Gets order history of the current user.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return List<CustomerOrder>
	 */	

	public List<CustomerOrder> getOrderHistory() {
		return orderService.getOrderHistory(currentUser.getCustomer().getId());
	}
	
	/**
	 *
	 * Gets order selected by comparing orderID passed with orderID from order history of the current user ( obtained from getOrderHistory() ).
	 *
	 *	 
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@param long
	 *@return CustomerOrder
	 */	
	
	public CustomerOrder getOrder(long orderId){
		List<CustomerOrder> orders = orderService.getOrderHistory(currentUser.getCustomer().getId());
		
		for(CustomerOrder order : orders){
			if(order.getId() == orderId){
				return order;
			}
		}
		return null;
	}
	
	/**
	 *
	 * Checks to see if current user is logged in.
	 * Gets the order using the ID passed.
	 * If there is an order then the Order Page is displayed
	 * If not then a 404 error page is displayed to the user.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@param long
	 *@return String
	 */	
	
	public String goToOrder(long orderId){
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		CustomerOrder order = getOrder(orderId);
		
		if(order == null){
			return "404"; // Order not found
		} else {
			this.orderId = order.getId();
			return "orderpage";
		}
	}

	/**
	 *
	 * Getter method for the Order ID.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return long
	 */	
	
	public long getOrderId() {
		return orderId;
	}
	
	
	
}
