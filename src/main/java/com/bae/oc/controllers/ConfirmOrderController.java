package com.bae.oc.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.services.AddressService;
import com.bae.oc.services.OrderService;



@Named("confirmorder")
@ConversationScoped
public class ConfirmOrderController {
	
	@Inject
	private OrderService orderService;
	@Inject
	private CurrentUser currentUser; 
	@Inject
	private AddressService addressService;
	
	private CustomerOrder customerOrder;
	
	
	/**
	 *
	 * Method checks if user is logged in.
	 * If so, gets the basket from the current user, and adds it to temporary memory.
	 * Then checks that basket if it follows the business rules.
	 * If no exception is thrown, it returns the order details page.
	 * Exceptions caught and dealt with (will need to be looked over once exceptions are created)
	 *
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */	
	
	public String goToOrderDetails(){
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		try{
			customerOrder = orderService.getBasket(currentUser.getCustomer().getId());
			orderService.checkBasket(customerOrder.getId());
			return "orderdetails";
		} catch (Exception e) {
			return null;
		}
	}
	
	public String goToOverview() {
		return null;
		
	}
	
	public String confirmOrderSubmit(){
		return null;
		
	}
	
}
