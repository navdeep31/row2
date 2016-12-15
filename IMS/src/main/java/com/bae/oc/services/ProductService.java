package com.bae.oc.services;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Product;
import com.bae.oc.enums.ProductStatus;
import com.bae.oc.managers.ProductManager;

/**
 * 
 * @author Tim Spencer
 * @version 0.1
 *
 */
@Stateless
public class ProductService {
	@Inject
	ProductManager productManager;
	
	/**
	 * 
	 * Creates a product and checks if fields are correctly implemented. If not, throws an exception.
	 * Returns a newly created product on success. 
	 * 
	 * @MethodAuthor Tim Spencer
	 * 
	 * @param productID
	 * @param stockID
	 * @param name
	 * @param description
	 * @param quantity
	 * @param rrp
	 * @param currentPrice
	 * @param status
	 * @param dateAdded
	 * @param category
	 * @return Product. 
	 */
	public Product createProduct(long productID, long stockID, String name, String description, int quantity, long rrp,
			long currentPrice, ProductStatus status, LocalDate dateAdded, String category) {
		
		return null; 
		
	}
	
	/**
	 * 
	 * Takes all variables as empty strings or the original quantity, unless they are changed.
	 * Checks if the fields are correctly entered. If not, throws an error. 
	 * 
	 * Returns the updated product on success. 
	 * 
	 * @param product
	 * @param name
	 * @param description
	 * @param quantity
	 * @param rrp
	 * @param currentPrice
	 * @param status
	 * @param category
	 * @return
	 */
	public Product updateProduct(Product product, String name, String description, int quantity, long rrp,
			long currentPrice, ProductStatus status, String category) {
				
		
		
		
			return product;
	
	}
	
	
	
}
