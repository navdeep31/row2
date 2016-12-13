/**
 * @author N GILL
 *
 */

package com.bae.oc.controllers.session;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.bae.oc.entities.Product;
import com.bae.oc.enums.ProductStatus;

@SessionScoped
@Named("selected")
public class SelectedProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2929402503570398917L;

	private Product product;
	
	/*
	 * EDITED getProduct() - manually set product to test xhtml Product Page. Original code below:
	 * getProduct(){return product;}
	 */

	public Product getProduct() {
		return product;
	}
	
		
	public void setProduct(Product product) {
		this.product = product;
	}

	
	public boolean getInStock(){
		if (product.getQuantity()>0){return true;}
		else {return false;}
	}
}

