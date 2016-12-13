/**
 * @author N GILL
 * @version 0.1
 */

package com.bae.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Product;
import com.bae.oc.managers.ProductManager;

@Stateless
public class ProductSearchService {
	
	//////////////////////////////////INJECTIONS/////////////////////////////////////
	
	@Inject
	private ProductManager productManager;
	
	@Inject
	private ProductService productService;
	
	//////////////////////////////////METHODS/////////////////////////////////////
	
	/**
	 * Returns similar names to search term
	 * 
	 * @param name
	 * @return List of Products
	 * 
	 * @MethodAuthor N GILL
	 */
	private List<Product> searchByProductName(String name){
		return productManager.findProductByNameLike(name);
	}
	
	/**
	 * Returns similar description to search term
	 * 
	 * @param description
	 * @return List of Products
	 * 
	 * @MethodAuthor N GILL
	 */
	private List<Product> searchByProductDescription(String description){
		return productManager.findProductByDescriptionLike(description);
	}
	
	
	/**
	 * Returns exact product if term matches a PID else finds products with similar name/description
	 * 
	 * @param search term
	 * @return List of Product(s)
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> searchBy(String term){
		List<Product> results = new ArrayList<>();
		if(term.matches("[0-9]")){
			Product result = productService.findProductByPId(term);
			if(result!=null) {
				results.add(result);
			}
		}
		results.addAll(searchByProductName(term));
		results.addAll(searchByProductDescription(term));
		if (results.isEmpty()) {return null;}
		else {return results;}
		
	}

}
