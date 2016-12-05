package com.bae.oc.managers;

import java.util.List;

import com.bae.oc.entities.Product;

/**
 * 
 * @author Tim Spencer
 *
 */

public interface BasketManager {
	/**
	 * Find a customer's basket
	 * 
	 * @param id
	 * @return
	 *  
	 */
	
	List<Product> findByCustomerId(long id);
	 
	/**
	 * Updates a customer's basket
	 * 
	 * @param customerId
	 * @return
	 * 
	 */
	
	void updateWishList(long customerId, List<Product> wishlist);
}
