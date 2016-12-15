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
		
		//TODO Validation below
		
		Product product = new Product(productID, stockID, name, description, quantity, rrp, currentPrice, status, dateAdded, category);	
		productManager.createNewProduct(product);
		
		return product; 
		
	}
	/**
	 * Overloaded version of created product that takes Strings instead of primitives. Used for parsing. 
	 * Does not add products to the database, instead calls non-overloaded method which does this. 
	 * 
	 * @MethodAuthor
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
	 * @return
	 * @throws Exception 
	 */
	public Product createProduct(String productID, String stockID, String name, String description, String quantity, String rrp, String currentPrice, String status, String dateAdded, String category) throws Exception {
		
		long lProductID;
		long lStockID;
		int iQuantity;
		long lCurrentPrice;
		long lRRP;
		ProductStatus eStatus; 
		LocalDate ldDateAdded;
		
		try {
			
			lProductID = Long.parseLong(productID); 
			lStockID = Long.parseLong(stockID);
			if(!quantity.isEmpty()) {
			iQuantity = Integer.parseInt(quantity);
			} else {
				iQuantity = 0;
			}
			lCurrentPrice = Long.parseLong(currentPrice);
			lRRP = Long.parseLong(rrp);
			// Work out how this works
			ldDateAdded = LocalDate.parse(dateAdded); 
			
			//Modify if feel like it
			if(status.isEmpty()) {
				eStatus = ProductStatus.AVALIABLE;
			} else if (status.equals("AVALIABLE")) {
				eStatus = ProductStatus.AVALIABLE;
			} else if (status.equals("ON_HOLD")) {
				eStatus = ProductStatus.ON_HOLD;
			} else if (status.equals("DISCONTINUED")) {
				eStatus = ProductStatus.DISCONTINUED;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception("format exception"); 
		}
		
		Product product = createProduct(lProductID, lStockID, name, description, iQuantity, lRRP, lCurrentPrice, eStatus, ldDateAdded, category);
		
		return product;
		
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
