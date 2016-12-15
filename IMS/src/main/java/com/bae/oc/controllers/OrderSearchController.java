package com.bae.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedOrder;
import com.bae.oc.controllers.session.SelectedOrders;
import com.bae.oc.entities.Product;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.services.OrderSearchService;

/**
 * Deals with (order) search terms and setting SelectedOrders as a result
 * 
 * @author Alex Dawson
 *
 */
@Named("orderSearch")
@RequestScoped
public class OrderSearchController {
	
	//////////////////////////////////INJECTIONS/////////////////////////////////////
	
	@Inject
	private OrderSearchService searchService;
	
	@Inject 
	private SelectedOrder order;
	@Inject
	private SelectedOrders orders;
	
	/////////////////////////////////ATTRIBUTES//////////////////////////////////////
	
	private String term;
	
	////////////////////////////////METHODS/////////////////////////////////////////
	
	/**
	 * Puts search results into List
	 * checks for no results 
	 * if 1 product found takes you directly to product page and sets selected product
	 * 
	 * @return A string to navigate to the correct web page based on search results
	 * 
	 * @MethodAuthor N Gill
	 * 
	 */
	public String search(){
		List<PurchaseOrder> results = searchService.searchBy(term);
		if (results != null){
			
			if (results.size() == 1) {
				
				order.setOrder(results.get(0));
				return "products";
				
			} else {
				
				orders.setOrders(results);
				return "products";
				
			}
			
		} else {
			
			//TODO Page to return to if search fails?
			// Currently no dedicated page to deal with this
			return "";
			
		}
		
	}

	/**
	 * 
	 * @return Search term
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * 
	 * @param term Search term
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setTerm(String term) {
		this.term = term;
	}

}
