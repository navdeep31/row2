package com.bae.oc.services;

import java.io.IOException;
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
	 * Creates a product and checks if fields are correctly implemented. If not,
	 * throws an exception. Returns a newly created product on success.
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
	 * @throws IOException
	 */
	public Product createProduct(long productID, long stockID, String name, String description, int quantity, long rrp,
			long currentPrice, ProductStatus status, LocalDate dateAdded, String category) throws IOException {

		// TODO Validation below
		if ((productID < 0) || (stockID < 0) || (quantity <= 0) || (rrp <= 0) || (currentPrice <= 0)) {
			throw new IOException();
		}

		Product product = new Product(productID, stockID, name, description, quantity, rrp, currentPrice, status,
				dateAdded, category);
		productManager.createNewProduct(product);

		return product;

	}

	/**
	 * Overloaded version of created product that takes Strings instead of
	 * primitives. Used for parsing. Does not add products to the database,
	 * instead calls non-overloaded method which does this.
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
	public Product createProduct(String productID, String stockID, String name, String description, String quantity,
			String rrp, String currentPrice, String status, String dateAdded, String category) throws Exception {

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
			if (!quantity.isEmpty()) {
				iQuantity = Integer.parseInt(quantity);
			} else {
				iQuantity = 0;
			}
			lCurrentPrice = Long.parseLong(currentPrice);
			lRRP = Long.parseLong(rrp);
			// Work out how this works
			ldDateAdded = LocalDate.parse(dateAdded);

			// Modify if feel like it
			if (status.isEmpty()) {
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

		Product product = createProduct(lProductID, lStockID, name, description, iQuantity, lRRP, lCurrentPrice,
				eStatus, ldDateAdded, category);

		return product;

	}

	/**
	 * 
	 * Takes all variables as empty strings or the original quantity, unless
	 * they are changed. Checks if the fields are correctly entered. If not,
	 * throws an error.
	 * 
	 * Returns the updated product on success.
	 * 
	 * @MethodAuthor Tim Spencer
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

	/**
	 * 
	 * Overloaded update products that provides variables as strings, parses them, and 
	 * calls the non-String method above. Throws an exception if parsing fails.
	 * 
	 * @MethodAuthor Tim Spencer
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
	 * @throws Exception
	 */
	public Product updateProduct(Product product, String name, String description, String quantity, String rrp,
			String currentPrice, String status, String category) throws Exception {

		int iQuantity;
		long lCurrentPrice;
		long lRRP;
		ProductStatus eStatus;

		try {

			if (!quantity.isEmpty()) {
				iQuantity = Integer.parseInt(quantity);
			} else {
				iQuantity = product.getQuantity();
			}
			if (!currentPrice.isEmpty()) {
				lCurrentPrice = Long.parseLong(currentPrice);
			} else {
				lCurrentPrice = product.getCurrentPrice();
			}
			if (!rrp.isEmpty()) {
				lRRP = Long.parseLong(rrp);
			} else {
				lRRP = product.getRrp();
			}

			if (status.isEmpty()) {
				eStatus = product.getStatus();
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

		product = updateProduct(product, name, description, iQuantity, lRRP, lCurrentPrice, eStatus, category); 
		
		return product;

	}

}
