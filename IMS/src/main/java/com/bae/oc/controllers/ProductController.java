package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.services.ProductService;
/**
 * 
 * @author Tim Spencer
 * @version 0.1
 *
 */

@RequestScoped
@Named("product")
public class ProductController {
	@Inject
	private SelectedProduct selectedProduct;
	@Inject
	private ProductService productService;
	
	private String name = "";
	
	private String description = "";
	
	private String quantity = ""; 
	
	private String rrp = ""; 
	
	private String currentPrice = ""; 
	
	private String status = "";
	
	private String category = ""; 
	
	/**
	 * 
	 * Update products through empty categories or placeholders (may use patterns when 
	 * actually built). 
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 * 
	 */
	public String updateProduct() {
		try {
			selectedProduct.setProduct(productService.updateProduct(selectedProduct.getProduct(), name, description, quantity, rrp, currentPrice, status, category));
			return "productpage"; 
		} catch(Exception e) {
			System.out.println(e);
			return "createproduct";
		}
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Returns name as a String. 
	 * @return String
	 */
	public String getName() {
		if(this.name.isEmpty()) {
			return selectedProduct.getProduct().getName();
		}
		
		return name;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets name, passed as a String. 
	 * @param String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets description as a String. 
	 * @return String
	 */
	public String getDescription() {
		if(this.description.isEmpty()) {
			return selectedProduct.getProduct().getDescription();
		}
		
		return description;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets name as a String. 
	 * @param String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets quantity as int. 
	 * @return int
	 */
	public String getQuantity() {
		if(this.quantity.isEmpty()) {
			return "" + selectedProduct.getProduct().getQuantity();
		}
		
		return ("" + quantity);
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets quantity through int. 
	 * @param int
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get rrp as a long (in pence). 
	 * @return long
	 */
	public String getRrp() {
		if(this.rrp.isEmpty()) {
			return "" + selectedProduct.getProduct().getQuantity();
		}
		
		return rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets rrp as a long (in pence).
	 * @param long
	 */
	public void setRrp(String rrp) {
		this.rrp = rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get current price as a long (in pence). 
	 * @return long
	 */
	public String getCurrentPrice() {
		if(this.currentPrice.isEmpty()) {
			return "" + selectedProduct.getProduct().getCurrentPrice();
		}
		
		return currentPrice;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets current price as a long (in pence).
	 * @param long
	 */
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get status as ProductStatus(enum)
	 * @return ProductStatus
	 */
	public String getStatus() {
		if(this.status.isEmpty()) {
			return "" + selectedProduct.getProduct().getStatus();
		}
		
		return status;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Set status as ProductStatus(enum)
	 * @param ProductStatus
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets category as a String. 
	 * @return String
	 */
	public String getCategory() {
		if(this.category.isEmpty()) {
			return selectedProduct.getProduct().getCategory();
		}
		
		return this.category;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets category as a String.  
	 * @return String
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets product id as a String.
	 * @return String
	 */
	public String getProductId() {
		return "" + selectedProduct.getProduct().getProductID();
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets stock id as a String.
	 * @return String
	 */
	public String getStockId() {
		return "" + selectedProduct.getProduct().getStockID();
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get date added in LocalDate format.
	 * @return LocalDate
	 */
	public String getDateAdded() {
		
		return selectedProduct.getProduct().getName(); 
	}
	
}
