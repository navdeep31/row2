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
	
	public List<Product> findProductByNameLike(String name);
	
	public List<Product> findProductByDate(LocalDate date);
	
	public List<Product> findProductByStatus(String status);
	
	public List<Product> findProductByCategory(String category);
	
	//Assume Product in pence hence integer
	public List<Product> findProductByPrice(int price);
	
	public List<Product> findProductByDescriptionLike(String description);
	
	public List<Product> findAllProducts();
	
	public Product findProductByPId(long productID);
	
//	No longer using PID like - could potentially return all products.
//	public List<Product> findProductByPIdLike(long productID);
	
	public List<Product> findProductBySId(long stockID);
	
	

	


}
