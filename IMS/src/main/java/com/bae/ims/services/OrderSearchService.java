package com.bae.ims.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.managers.PurchaseOrderManager;

/**
 * Deals with methods for order search and returning lists of orders
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
 *
 */
@Stateless
public class OrderSearchService {
	
	//////////////////////////////////INJECTIONS/////////////////////////////////////
	
	@Inject
	private PurchaseOrderManager orderManager;
	
	//////////////////////////////////METHODS/////////////////////////////////////
	
	//TODO More search / filter methods
	
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
	
	public List<PurchaseOrder> searchAll() {
		return orderManager.findAllPurchaseOrders();
	}
	

}
