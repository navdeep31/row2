package com.bae.ims.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.ims.controllers.session.SelectedOrder;
import com.bae.ims.controllers.session.SelectedOrders;
import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.services.OrderSearchService;

/**
 * Deals with (order) search terms and setting SelectedOrders as a result
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
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
	 * Searching by term
	 * 
	 * @return String of next page to navigate to
	 * 
	 * @MethodAuthor Alex Dawson
	 * 
	 */
	public String search(){
		List<PurchaseOrder> results = searchService.searchBy(term);
		if (results != null){
			
			if (results.size() == 1) {
				
				order.setOrder(results.get(0));
				return "orderhistory";
				
			} else {
				
				orders.setOrders(results);
				return "orderhistory";
				
			}
			
		} else {
			
			//TODO Page to return to if search fails?
			// Currently no dedicated page to deal with this
			return "";
			
		}
		
	}
	
	/**
	 * Searches for all purchase orders
	 * 
	 * @return String of next page to navigate to
	 * 
	 * @MethodAuthor Alex Dawson
	 * 
	 */
	public String searchAll() {
		setTerm("");
		search();
		return "orderhistory";
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
