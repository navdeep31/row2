/**
 * @author N GILL
 *
 */
package com.bae.oc.managers;

import java.time.LocalDate;
import java.util.List;

import com.bae.oc.entities.Product;

public interface ProductManager {

	public void createNewProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProduct(Product product);
	
	public List<Product> findProductByName(String name);
	
	public List<Product> findProductByDate(LocalDate date);
	
	public List<Product> findProductByStatus(String status);
	
	public List<Product> findProductByCategory(String category);
	
	//Assume Product in pence hence integer
	public List<Product> findProductByPrice(int price);
	
	public List<Product> findProductByDescription(String description);
	
	public List<Product> findAllProducts();
	
	public List<Product> findProductByPId(long productID);
	
	public List<Product> findProductBySId(long stockID);
	
	

	


}
