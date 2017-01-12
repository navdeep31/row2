package com.bae.ims.controllers;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.ims.controllers.session.SelectedProduct;
import com.bae.ims.enums.ProductStatus;
import com.bae.ims.services.ProductService;

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
	
	private String productId = "";
	
	private String stockId = "";
	
	private String name = "";
	
	private String description = "";
	
	private String quantity = ""; 
	
	private String rrp = ""; 
	
	private String currentPrice = ""; 
	
	private String status = "";
	
	private String dateAdded = "";
	
	private String category = ""; 
	
	
	/**
	 * @MethodAuthor Tim Spencer
	 * Creates a product by using variables passed through getters/setters, checking if they are blank or not. 
	 * Depending on build type, may use placeholder variables or a builder pattern. 
	 * @return String
	 */
	public String createProduct() {
		try {
			System.out.println("problem here");
			selectedProduct.setProduct(productService.createProduct(productId, stockId, name, 
					description, quantity, rrp, currentPrice, status, dateAdded, category));
			
			return "products"; 
			
		} catch (Exception e) {
			System.out.println(e.toString());
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
	 * Gets quantity as String. 
	 * @return String
	 */
	public String getQuantity() {
		return quantity;
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
	 * Get rrp as a String (in pence). 
	 * @return String
	 */
	public String getRrp() {
		return rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets rrp as a String (in pence).
	 * @param String
	 */
	public void setRrp(String rrp) {
		this.rrp = rrp;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get current price as a String (in pence). 
	 * @return String
	 */
	public String getCurrentPrice() {
		return currentPrice;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Sets current price as a String (in pence).
	 * @param String 
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
		return status;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Set status as ProductStatus(enum) as a String
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
	 * Gets product id as a String.
	 * @return long
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Gets stock id as a String.
	 * @return long
	 */
	public String getStockId() {
		return stockId;
	}
	
	/**
	 * 
	 * @MethodAuthor Tim Spencer
	 * Get date added in LocalDate format as a String.
	 * @return LocalDate
	 */
	public String getDateAdded() {
		return dateAdded;
	}
	
	
	
	
	
}
