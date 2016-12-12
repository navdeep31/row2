package com.bae.oc.controllers.session;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.bae.oc.entities.Product;
import com.bae.oc.util.PaginationHelper;

/**
 * Stores search results and gets results by page with pagination
 * 
 * @author Alex Dawson
 * @author Conor White
 * @author Navdeep Gill
 *
 */
@Named("searchResults")
@SessionScoped
public class SearchResultsController implements Serializable {
	
	private static final long serialVersionUID = 4604194124385366184L;

	private PaginationHelper pagination = null;
	
	private DataModel<Product> pageResults = null;
	
	private List<Product> searchResults;
	
	/**
	 * Gets the current pagination
	 * If doesn't currently exists creates a new one
	 * 
	 * @return PaginationHelper
	 * 
	 * @MethodAuthor Alex Dawson
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	public PaginationHelper getPagination() {
		
		if(pagination == null) {
			//TODO Check number of products per page when written HTML
			pagination = new PaginationHelper(9) {
				
				@Override
				public int getItemsCount() {
					return searchResults.size();
				}
				
				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(searchResults.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(searchResults.subList(getPageFirstItem(), getItemsCount()));
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
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
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
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
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
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "results";
	}
	
	/**
	 * Gets page results
	 * 
	 * @return Data Model (List) of page of products
	 * 
	 * @MethodAuthor Alex Dawson
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	@SuppressWarnings("unchecked")
	public DataModel<Product> getPageResults() {
		if(pageResults == null) {
			pageResults = (DataModel<Product>) getPagination().createPageDataModel();
		}
		return this.pageResults;
	}
	
	/**
	 * Sets entire list of search results (from e.g. search controller)
	 * 
	 * @param iSearchResults List of Products
	 * 
	 * @MethodAuthor Alex Dawson
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	public void setSearchResults(List<Product> iSearchResults) {
		pagination = null;
		pageResults = null;
		this.searchResults = iSearchResults;
	}

}
