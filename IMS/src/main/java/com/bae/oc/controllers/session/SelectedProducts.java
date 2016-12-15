package com.bae.oc.controllers.session;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.bae.oc.entities.Product;
import com.bae.oc.util.PaginationHelper;

/**
 * 
 * @author Tim Spencer
 * @version 0.1
 */
@SessionScoped
@Named("products")
public class SelectedProducts {
	
	private PaginationHelper pagination = null;

	private DataModel<Product> pageProducts;
	
	private List<Product> searchResults;
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets the paginationhelper. Will create a new pagination helper if it 
	 * isn't created. 
	 * @return PaginationHelper
	 */
	public PaginationHelper getPagination() {
		if(pagination == null) {
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
	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}
	public DataModel<Product> getPageProducts() {
		return pageProducts;
	}
	public void setPageProducts(DataModel<Product> pageProducts) {
		this.pageProducts = pageProducts;
	} 
	
	/**
	 * Resets the page results to null (so they can be repopulated when next loaded)
	 * 
	 * @MethodAuthor Alex Dawson
	 * @MethodAuthor Conor White
	 * @MethodAuthor Navdeep Gill
	 */
	private void recreateModel() {
		pageProducts = null;
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
	public DataModel<Product> getpageProducts() {
		if(pageProducts == null) {
			pageProducts = (DataModel<Product>) getPagination().createPageDataModel();
		}
		return this.pageProducts;
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
		pageProducts = null;
		this.searchResults = iSearchResults;
	}
	public List<Product> getSearchResults() {
		return searchResults;
	}
	
	

	
	
}
