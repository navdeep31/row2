package com.bae.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.util.BasketService;
import com.bae.oc.util.ProductItem;

/**
 * 
 * @author Tim Spencer
 *
 */

@Named("basket")
@RequestScoped
public class BasketController {
	@Inject
	private BasketService basketService;
	@Inject
	private CurrentUser currentUser;
	private List<ProductItem> basket;



	public void addToBasket(long id) {
		/*if (currentUser.isLoggedIn()) {
			basketService.addToBasket(currentUser.getCustomer().getId(), id);*/
		}
	
	
	public String removeItem(long id) {
		return null;
		/*basketService.removeFromBasket(currentUser.getCustomer().get());
		return "basket";*/
	}
	
	public List<ProductItem> getBasket() {
		/*if(basket==null) {
			basket = basketService.getBasket(currentUser.getCustomer().get());
		}*/
		return basket; 
		
	}
}
