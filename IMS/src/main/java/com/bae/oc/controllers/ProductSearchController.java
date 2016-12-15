package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.controllers.session.SelectedProducts;
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
		return null;
	}
	
	
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	
}
