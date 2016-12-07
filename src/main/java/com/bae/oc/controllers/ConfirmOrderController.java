package com.bae.oc.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.entities.Address;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.services.AddressService;
import com.bae.oc.services.OrderService;

/**
 * Controller for the Confirm Order
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 * @version 0.1 07/12/2016
 *
 */

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
	
	private String bLine1;
	private String bLine2;
	private String bCity;
	private String bPostcode;
	
	private String dLine1;
	private String dLine2;
	private String dCity;
	private String dPostcode;
	
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
	
	/**
	 * Method checks if user is logged in; if not goes to log in page. 
	 * It validates all the address details. If there are no problems, then address is checked to see if it already exists.
	 * If so then the original address (with original ID) is passed, if not the new address is passed and added to the customerOrder. 
	 * Then it passes them to the confirmation page.
	 * If the address doesn't validate return them back to the orderdetails page. 
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */	
	
	public String goToOverview() {
		boolean success = false;
		boolean bLine2NotNull = (bLine2 !=null); 
		boolean dLine2NotNull = (dLine2 !=null); 
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
			
		if(bLine2NotNull){
		success = addressService.isValidAddress(bLine1, bLine2, bPostcode, bCity);
		} else {
		success = addressService.isValidAddress(bLine1, bPostcode, bCity);
		}
		if(success && bLine2NotNull){
			customerOrder.setBillingAddress(addressService.checkAddressExists(new Address(bLine1, bLine2, bPostcode, bCity)));
		} else if (success) {
			customerOrder.setBillingAddress(addressService.checkAddressExists(new Address(bLine1, bPostcode, bCity)));
		} else {
			return "orderdetails";
		}
		
		success = false;
		
		if(dLine2NotNull){
			success = addressService.isValidAddress(dLine1, dLine2, dPostcode, dCity);
		} else {
			success = addressService.isValidAddress(dLine1, dPostcode, dCity);
		}
		if(success && dLine2NotNull){
			customerOrder.setDeliveryAddress(addressService.checkAddressExists(new Address(bLine1, bLine2, bPostcode, bCity)));
		} else if (success) {
			customerOrder.setDeliveryAddress(addressService.checkAddressExists(new Address(bLine1, bPostcode, bCity)));
		} else {
			return "orderdetails";
		}
		
		
		return "confirmorder";
		
	}
	
	/**
	 * Method checks if user is logged in; if not goes to log in page. 
	 * Calls the confirmOrder() from Order Service to change order status to ORDER.
	 * Returns customer to accounts page.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */	
	
	public String confirmOrderSubmit(){
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		orderService.confirmOrder(customerOrder.getId());
		return "accounts";
		
		// TODO If time create e-mail confirmation here
		
	}
	
	// TODO Comment Getters & Setters

	public String getbLine1() {
		return bLine1;
	}

	public void setbLine1(String bLine1) {
		this.bLine1 = bLine1;
	}

	public String getbLine2() {
		return bLine2;
	}

	public void setbLine2(String bLine2) {
		this.bLine2 = bLine2;
	}

	public String getbCity() {
		return bCity;
	}

	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	public String getbPostcode() {
		return bPostcode;
	}

	public void setbPostcode(String bPostcode) {
		this.bPostcode = bPostcode;
	}

	public String getdLine1() {
		return dLine1;
	}

	public void setdLine1(String dLine1) {
		this.dLine1 = dLine1;
	}

	public String getdLine2() {
		return dLine2;
	}

	public void setdLine2(String dLine2) {
		this.dLine2 = dLine2;
	}

	public String getdCity() {
		return dCity;
	}

	public void setdCity(String dCity) {
		this.dCity = dCity;
	}

	public String getdPostcode() {
		return dPostcode;
	}

	public void setdPostcode(String dPostcode) {
		this.dPostcode = dPostcode;
	}
	
	
	
}
