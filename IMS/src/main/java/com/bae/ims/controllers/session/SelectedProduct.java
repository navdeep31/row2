package com.bae.ims.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.ims.entities.Product;

/**
 * Stores Selected Product (selected product on products page to view details, edit, add to basket)
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
 *
 */
@Named("selectedProduct")
@SessionScoped
public class SelectedProduct implements Serializable {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	private static final long serialVersionUID = 4604194124385366184L;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private Product product = null;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Returns Selected Product
	 * 
	 * @return Selected Product
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Product getProduct() {
		return this.product;
	}
	
	/**
	 * Sets Selected Product
	 * 
	 * @param iOrder Selected Product to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setProduct(Product iProduct) {
		this.product = iProduct;
	}

}
