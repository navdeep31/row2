package com.bae.oc.controllers;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.enums.ProductStatus;
import com.bae.oc.services.ProductService;

/**
 * 
 * @author Tim Spencer
 * @version 0.1
 *
 */

@RequestScoped
@Named("newProduct")
public class NewProductController {
	
	@Inject
	SelectedProduct selectedProduct; 
	@Inject
	ProductService productService; 
	
	private long productId;
	
	private long stockId;
	
	private String name = "";
	
	private String description = "";
	
	private int quantity; 
	
	private long rrp; 
	
	private long currentPrice; 
	
	private ProductStatus status;
	
	private LocalDate dateAdded;
	
	private String category = ""; 
	
	
	/**
	 * @MethodAuthor Tim Spencer
	 * Creates a product by using variables passed through getters/setters, checking if they are blank or not. 
	 * Depending on build type, may use placeholder variables or a builder pattern. 
	 * @return String
	 */
	public String createProduct() {
		return category;
		
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
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets quantity through int. 
	 * @param int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get rrp as a long (in pence). 
	 * @return long
	 */
	public long getRrp() {
		return rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets rrp as a long (in pence).
	 * @param long
	 */
	public void setRrp(long rrp) {
		this.rrp = rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get current price as a long (in pence). 
	 * @return long
	 */
	public long getCurrentPrice() {
		return currentPrice;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets current price as a long (in pence).
	 * @param long
	 */
	public void setCurrentPrice(long currentPrice) {
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
	public long getProductId() {
		return productId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets stock id a a long.
	 * @return long
	 */
	public long getStockId() {
		return stockId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get date added in LocalDate format.
	 * @return LocalDate
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	
	
}
