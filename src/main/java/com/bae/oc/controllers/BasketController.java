package com.bae.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.services.OrderService;

/**
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 *
 * @version 0.1
 */

@Named("basket")
@RequestScoped
public class BasketController implements Serializable {

	private static final long serialVersionUID = -8664519487305604764L;
	
	@Inject
	private OrderService orderService;
	@Inject
	private CurrentUser currentUser;
	@Inject
	private SelectedProduct selectedProduct;
	private CustomerOrder basket;
	
	/**
	 *Method firstly uses the isLoggedIn() method from the CurrentUser Session Controller to determine if a user is logged in. If not they are returned to the login page
	 *productId and customerOrderId are set from calling the getProductID() getter from selectedProduct session controller and getBasket() method from the orderService
	 *
	 *Once this is set then the addToBasket() is called passing the productId and customerOrderId variables
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */
	
	public String addToBasket() {
		
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		long productId = selectedProduct.getProduct().getProductID();
		long customerOrderId = orderService.getBasket(currentUser.getCustomer().getId()).getId();
		
		orderService.addToBasket(customerOrderId, productId);		
		
			return null;	
	}
	
	/**
	 *Method firstly uses the isLoggedIn() method from the CurrentUser Session Controller to determine if a user is logged in. If not they are returned to the login page
	 *productId and customerOrderId are set from calling the getProductID() getter from selectedProduct session controller and getBasket() method from the orderService
	 *
	 *Once this is set then the removeFromBasket() is called passing the productId and customerOrderId variables
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */
	
	public String removeFromBasket() {
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		long productId = selectedProduct.getProduct().getProductID();
		long customerOrderId = orderService.getBasket(currentUser.getCustomer().getId()).getId();
		
		orderService.removeFromBasket(customerOrderId, productId);
		
		return "basket";
	}

	/**
	 *Method firstly uses the isLoggedIn() method from the CurrentUser Session Controller to determine if a user is logged in. 
	 *This method then sets the basket attribute from the current user's id and calling orderService's get basket method.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@return String
	 */
	
	
	public String getBasket() {
		if(currentUser.isLoggedIn() == false) {
			return "login";
		} else {		
		basket = orderService.getBasket(currentUser.getCustomer().getId());		
		return null;
		}
	}
	/*
	 * May be used later, used specifically for gatekeeping use of the basket button. Redundant now thanks to above method. 
	 * 
	public String checkBasketButton() {
		if(currentUser.isLoggedIn() == false) {
			return "login";
		} else {
			return "basket";
		}
	}
	*/
	
	
	/**
	 *Method firstly uses the isLoggedIn() method from the CurrentUser Session Controller to determine if a user is logged in. 
	 *This method then sets the basket attribute from the current user's id and calling orderService's get basket method.
	 *
	 *@MethodAuthor Andrew Claybrook
	 *@MethodAuthor Tim Spencer
	 *@param String
	 *@return String
	 */
	public String updateQuantity(String quantity) {
		if(currentUser.isLoggedIn() == false) {
			return "login";
		}
		try{
			orderService.updateQuantity(orderService.getBasket(currentUser.getCustomer().getId()).getId(), selectedProduct.getProduct().getProductID(), quantity);
			return "basket";
		} catch(Exception e) {
			return "placeholder";
		}
	
	
	}
	
}
