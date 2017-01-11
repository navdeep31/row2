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
		
		// Generate results by different search methods for given term
		List<Product> nameResults = searchByProductName(term);
		List<Product> descriptionResults = searchByProductDescription(term);
		if(term.matches("[0-9]")){
			Product idResult = productService.findProductByPId(term);
			if(idResult != null) {
				descriptionResults.add(idResult);
			}
		}
		
		// Collate search results into single list of unique entries
		List<Product> results = nameResults;
		for(Product product: descriptionResults) {
			if(!results.contains(product)) {
				results.add(product);
			}
		}
		
		if (results.isEmpty()) {return null;}
		else {return results;}
		
	}

}
