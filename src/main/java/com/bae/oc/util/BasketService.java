package com.bae.oc.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.managers.ProductManager;

/**
 * 
 * @author Tim Spencer
 *
 */
@Stateless 
public class BasketService {
	
	private Customer customer; 
	@Inject
	private ProductManager productManager;
	@Inject
	private ProductService productService;
	
	/**
	 * Need to add stock manager that pulls from Mongo, but not built yet.
	 */
	
	
	public List<ProductItem> getBasket (long id) {
		List<ProductItem> basket = new ArrayList<>();
		return basket;

	}
	
	public void addToBasket(long customerId, long productId) {
		
	}
	
	public void removeFromBaset(long customerId, long productId) {
		
	}

}
