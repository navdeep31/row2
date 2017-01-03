package com.bae.ims.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.ims.entities.Product;
import com.bae.ims.managers.ProductManager;

/**
 * 
 * @author Tim Spencer
 * @version 0.1
 */

@Stateless
public class ProductSearchService {
	@Inject
	ProductManager productManager;
	
	/**
	 * 
	 * Is given a term from the front end, which is processes and validates
	 * A list is returned of all that is found. 
	 * 
	 * @param term
	 * @return List<Product>
	 */
	public List<Product> searchBy(String term) {
		List<Product> productsFound = new ArrayList<>();
		if(term.matches("[0-9]")) {
			Long productId = Long.parseLong(term); 
			Product result = productManager.findProductByPId(productId); 
			if(result!=null) {
				productsFound.add(result);
			}
		}
		productsFound.addAll(productManager.findProductByNameLike(term)); 
		productsFound.addAll(productManager.findProductByCategory(term));
		
		return productsFound;
	}
	
	public List<Product> searchAll(){
		return productManager.findAllProducts();
	}
	
	
}
