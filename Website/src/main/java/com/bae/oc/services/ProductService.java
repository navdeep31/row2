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
	 * @return Matching product
	 * 
	 * @MethodAuthor N GILL
	 */
	public Product findProductByPId(String productId){
		try{
			return findProductByPId(Long.parseLong(productId));
		} catch (Exception e){
			return null;
		}
	}
	
	/**
	 * find product by Product ID where PID is a long (overloaded)
	 * 
	 * @return Matching product
	 * 
	 * @MethodAuthor N GILL
	 */
	public Product findProductByPId(long productId){
		return productManager.findProductByPId(productId);
	}
	
	
	
	
//	No longer using PID like - could potentially return all products. see ProductManager	
//	/**
//	 * find all products with similar Product ID where PID is a string (overloaded)
//	 * 
//	 * @return List of found products
//	 * 
//	 * @MethodAuthor N GILL
//	 */
//	public List<Product> findProductByPIdLike(String productId){
//		try{
//			return findProductByPIdLike(Long.parseLong(productId));
//		} catch (Exception e){
//			return null;
//		}
//	}
//	
//	/**
//	 * find product with similar Product ID where PID is a long (overloaded)
//	 * 
//	 * @return List of found products
//	 * 
//	 * @MethodAuthor N GILL
//	 */
//	public List<Product> findProductByPIdLike(long productId){
//		return productManager.findProductByPIdLike(productId);
//	}
	
	
	
	
	
	
	
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
			return findProductBySId(Long.parseLong(stockId));
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
		return productManager.findProductBySId(stockId);
	}
	
	
	
	
	
	
	/**
	 * find products by name
	 * 
	 * @return List of found products
	 * 
	 * @MethodAuthor N GILL
	 */
	public List<Product> findProductByName(String name){
		return productManager.findProductByNameLike(name);
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
		return productManager.findProductByDescriptionLike(description);
	}
	

}
