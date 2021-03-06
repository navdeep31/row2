package com.bae.oc.controllers;

import java.io.Serializable;
import java.time.Month;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.services.OrderService;
// ?? Doesn't currently exist - unknown author
//import com.bae.oc.util.StringFormatter;

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
public class OrderHistoryController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7077424126556958734L;
	@Inject
	private OrderService orderService;
	@Inject
	private CurrentUser currentUser;
	private List<CustomerOrder> orderHistory;
	private long orderId;
	private int lineNumber = 0;
	
	/**
	 *
	 * Gets order history of the current user.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return List<CustomerOrder>
	 */	

	public List<CustomerOrder> getOrderHistory() {

		orderHistory = orderService.getOrderHistory(currentUser.getCustomer().getId());
		
		return orderHistory;
				
	}
	
	public String setOrderHistory(){
		if(currentUser.isLoggedIn() == false) {
			return "login";
		} else {
			orderHistory = orderService.getOrderHistory(currentUser.getCustomer().getId());
			return "";
		}
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

	public int getEnumValue(){
		long id = orderHistory.get(lineNumber).getId();
		
		return orderService.getStatusValue(id);
	}
	
	public String getEnumValueString(){
		long id = orderHistory.get(lineNumber).getId();
		
		String status = "";
		switch(orderService.getStatusValue(id)){
	case 0: break;
	case 25:
		status = "Your order has been placed";
		break;
	case 50:
		status = "On the way...";
		break;
	case 75:
		status = "Your order has been delivered. Payment is still outstanding.";
		break;
	case 100:
		status = "Your order has been delivered and paid in full.";
		break;
		}
		return status;
	}
	
	public String getOrderString() {
		
		// ?? Alternative version that doesn't compile currently - unknown author
		// return StringFormatter.properCasing((orderHistory.get(lineNumber).getStatus().toString()));
		
		return (orderHistory.get(lineNumber).getStatus().toString());
	}
	
	public String getOrderDate() {
			
		String day =""+ orderHistory.get(lineNumber).getOrderDate().getDayOfMonth();
		
		// ?? Alternative version taht doesn't compile currently - unknown author
		// String month = ""+ StringFormatter.properCasing(orderHistory.get(lineNumber).getOrderDate().getMonth().toString());
		String month = ""+ orderHistory.get(lineNumber).getOrderDate().getMonth().toString();
		
		String year = "" + orderHistory.get(lineNumber).getOrderDate().getYear();		
		
		return day + " " + month + " " + year;
		
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int iterateLineNumber() {	
		return lineNumber++;
				
	}
	
	
}
