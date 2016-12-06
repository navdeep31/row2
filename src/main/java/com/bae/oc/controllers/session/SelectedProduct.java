/**
 * @author N GILL
 *
 */

package com.bae.oc.controllers.session;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.bae.oc.entities.Product;

@SessionScoped
@Named("selected")
public class SelectedProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2929402503570398917L;
	
	private Product product;
	
	public Product getProduct(){return product;}
	public void setProduct(Product product){this.product = product;}

}
