package com.bae.oc.controllers;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.enums.ProductStatus;
import com.bae.oc.services.ProductService;

@RequestScoped
@Named("product")
public class ProductController {
	@Inject
	SelectedProduct selectedProduct;
	@Inject
	ProductService productService;
	
	private String productId;
	
	private String stockId;
	
	private String name = "";
	
	private String description = "";
	
	private String quantity; 
	
	private String rrp; 
	
	private String currentPrice; 
	
	private ProductStatus status;
	
	private String dateAdded;
	
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
		return null; 
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Returns name as a String. 
	 * @return String
	 */
	public String getName() {
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
	public ProductStatus getStatus() {
		return status;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Set status as ProductStatus(enum)
	 * @param ProductStatus
	 */
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets category as a String. 
	 * @return String
	 */
	public String getCategory() {
		return category;
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
	 * Gets product id as a long.
	 * @return long
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets stock id a a long.
	 * @return long
	 */
	public String getStockId() {
		return stockId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get date added in LocalDate format.
	 * @return LocalDate
	 */
	public String getDateAdded() {
		return dateAdded;
	}
	
}
