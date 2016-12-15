package com.bae.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Product;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.managers.ProductManager;
import com.bae.oc.managers.PurchaseOrderManager;

/**
 * Deals with methods for order search and returning lists of orders
 * 
 * @author Alex Dawson
 *
 */
@Stateless
public class OrderSearchService {
	
	//////////////////////////////////INJECTIONS/////////////////////////////////////
	
	@Inject
	private PurchaseOrderManager orderManager;
	
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
	 * Returns exact order if matches Order ID
	 * 
	 * @param iTerm Search Term (String)
	 * @return List of Product(s)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public List<PurchaseOrder> searchBy(String iTerm){
		
		List<PurchaseOrder> results = new ArrayList<>();
		
		// Dealing with numerical search terms
		if(iTerm.matches("[0-9]")){
			
			PurchaseOrder result = orderManager.findOrderById(Integer.parseInt(iTerm));
			
			if(result!=null) {
				
				results.add(result);
				
			}
			
		}
		
		//TODO Add all to results of other search methods
		
		
		// Returning null if no results
		//TODO Check appropriateness?
		if (results.isEmpty()) {
			return null;
		} else {
			return results;
		}
		
	}
	

}
