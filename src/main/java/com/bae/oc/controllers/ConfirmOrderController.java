package com.bae.oc.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
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
	
	private long customerOrderId;
	
	/**
	 *
	 * Method checks if user is logged in.
	 * If so, gets the basket from the current user.
	 * Then checks that basket if it follows the business rules.
	 * If no exception is thrown, it returns the order details page.
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
			customerOrderId = orderService.getBasket(currentUser.getCustomer().getId()).getId();
			orderService.checkBasket(customerOrderId);
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
