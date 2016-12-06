/**
 * @author N GILL
 * @version 0.1
 */

package com.bae.oc.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Product;
import com.bae.oc.managers.ProductManager;


@Stateless
public class ProductService {

	@Inject
	private ProductManager productManager;
	
	/**
	 * find All Products
	 * 
	 * @return List of All Products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findAllProducts(){
		return productManager.findAllProducts();
	}
	
	
	/**
	 * find product by Product ID where PID is a string (overloaded)
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	//TODO Doesn't need to return list - should only find 1 product - change return type in Product Manager
	public List<Product> findProductByPId(String productId){
		try{
			return findProductByPId(Long.parseLong(productId));
		} catch (Exception e){
			return null;
		}
	}
	
	/**
	 * find product by Product ID where PID is a long (overloaded)
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	//TODO Doesn't need to return list - should only find 1 product - change return type in Product Manager
	public List<Product> findProductByPId(long productId){
		return productManager.findProductByPId(productId);
	}
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////MIGHT NOT NEED FOLLOWING METHODS/////////////////////
	
	
	/**
	 * find product by Stock ID where SID is a string (overloaded)
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductBySId(String stockId){
		try{
			return findProductByPId(Long.parseLong(stockId));
		} catch (Exception e){
			return null;
		}
	}
	
	
	
	
	/**
	 * find product by Stock ID where SID is a long (overloaded)
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductBySId(long stockId){
		return productManager.findProductByPId(stockId);
	}
	
	
	
	
	
	
	/**
	 * find products by name
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByName(String name){
		return productManager.findProductByName(name);
	}
	
	
	/**
	 * find products by date
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductbyDate(LocalDate date){
		return productManager.findProductByDate(date);
	}
	
	
	
	
	/**
	 * find products by Status
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByStatus(String status){
		return productManager.findProductByStatus(status);
	}
	
	
	
	
	/**
	 * find products by category
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByCategory(String category){
		return productManager.findProductByCategory(category);
	}
	
	
	
	
	/**
	 * find products by price
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByPrice(int price){
		return productManager.findProductByPrice(price);
	}
	
	
	
	
	/**
	 * find products by description
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByDescription(String description){
		return productManager.findProductByDescription(description);
	}
	

}
