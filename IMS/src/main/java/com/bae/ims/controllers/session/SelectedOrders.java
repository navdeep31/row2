package com.bae.ims.controllers.session;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.util.PaginationHelper;

@Named("orders")
@SessionScoped
public class SelectedOrders implements Serializable {

	private static final long serialVersionUID = 5666702066654508767L;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private PaginationHelper pagination = null;
	
	private DataModel<PurchaseOrder> pageResults = null;
	
	private List<PurchaseOrder> orders;
	
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Gets the current pagination
	 * If doesn't currently exists creates a new one
	 * 
	 * @return PaginationHelper
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PaginationHelper getPagination() {
		
		if(pagination == null) {
			//TODO Check number of products per page when written HTML
			pagination = new PaginationHelper(9) {
				
				@Override
				public int getItemsCount() {
					return orders.size();
				}
				
				@Override
				public DataModel<PurchaseOrder> createPageDataModel() {
					try {
						return new ListDataModel<PurchaseOrder>(orders.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<PurchaseOrder>(orders.subList(getPageFirstItem(), getItemsCount()));
					}
				}
				
			};
		}
		
		return pagination;
	}
	
	/**
	 * Resets the page results to null (so they can be repopulated when next loaded)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	private void recreateModel() {
		pageResults = null;
	}
	
	/**
	 * Moves paginator to next page of results
	 * 
	 * @return Next page to navigate to
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "results";
	}
	
	/**
	 * Moves paginator to previous page of results
	 * 
	 * @return Next page to navigate to
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "results";
	}
	
	/**
	 * Gets page results
	 * 
	 * @return Data Model (List) of page of orders
	 * 
	 * @MethodAuthor Alex Dawson
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	@SuppressWarnings("unchecked")
	public DataModel<PurchaseOrder> getPageResults() {
		if(pageResults == null) {
			pageResults = (DataModel<PurchaseOrder>) getPagination().createPageDataModel();
		}
		return this.pageResults;
	}
	
	/**
	 * Sets entire list of search results (from e.g. order search controller)
	 * 
	 * @param iOrders List of Orders
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setOrders(List<PurchaseOrder> iOrders) {
		pagination = null;
		pageResults = null;
		this.orders = iOrders;
	}

	
}	
