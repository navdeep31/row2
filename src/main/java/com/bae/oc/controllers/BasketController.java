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

}

	public void addToBasket(long id) {
		if (currentUser.isLoggedIn()) {
			BasketService.addToBasekt(currentUser.getCustomer().getId(), id);
		}
	}
	
	public String removeItem(long id) {
		basketService.removeFromBasket(currentUser.getCustomer().get())
}
