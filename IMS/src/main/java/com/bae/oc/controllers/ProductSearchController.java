package com.bae.oc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.controllers.session.SelectedProducts;
import com.bae.oc.entities.Product;
import com.bae.oc.services.ProductSearchService;

@RequestScoped
@Named("productSearch")
public class ProductSearchController {
	@Inject
	SelectedProduct selectedProduct;
	@Inject
	SelectedProducts selectedProducts;
	@Inject
	ProductSearchService productSearchService;
	
	String term;

	/**
	 *  
	 * @MethodAuthor Tim Spencer
	 * Sets selected products, and sets the selected product if
	 * one item in selected products in returned. 
	 * @return String
	 */
	public String searchProducts() {
		List<Product> results = productSearchService.searchBy(term);
		
		if(results.size() == 1) {
			selectedProduct.setProduct(results.get(0));
			return "productpage";
		} else if (results.size() > 1) {
			selectedProducts.setSearchResults(results);
			return "resultspage";
		} else {
			return "emptyresults";
		}
		
		
	}
	
	
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	
}
