/**
 * @author N GILL
 *
 */
package com.bae.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SearchResultsController;
import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.services.ProductSearchService;
import com.bae.oc.entities.Product;


@Named("search")
@RequestScoped
public class SearchController {
	@Inject
	private ProductSearchService searchService;
	@Inject 
	private SelectedProduct selectedProduct;
	@Inject
	private SearchResultsController searchResults;
	private String term;
	
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
		List<Product> results = searchService.searchBy(term);
		if (results != null){
			if (results.size() == 1) {
				selectedProduct.setProduct(results.get(0));
				return "product";
			} else {
				searchResults.setSearchResults(results);
				return "searchResults";
			}}
		else {return "browse";}
	}

	public String getTerm() { return term; }
	public void setTerm(String term) { this.term = term; }
}

