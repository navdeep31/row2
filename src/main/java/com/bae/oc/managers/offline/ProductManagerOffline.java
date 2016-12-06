/**
 * @author N GILL
 *
 */

package com.bae.oc.managers.offline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Product;
import com.bae.oc.managers.ProductManager;
import com.bae.oc.util.TestData;

@Stateless
@Default
public class ProductManagerOffline implements ProductManager {
	@Inject
	private TestData testData;

	@Override
	public void createNewProduct(Product product) {
		List<Product> products = testData.getProducts();
		product.setProductID(products.size() + 1);
		products.add(product);
		testData.setProducts(products);
	}

	@Override
	public List<Product> findProductByNameLike(String name) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getName().equalsIgnoreCase(name)) {
				productsFound.add(product);
			}
		return productsFound;
	}


	@Override
	public List<Product> findProductByDate(LocalDate date) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getDateAdded().equals(date)){
				productsFound.add(product);
			}
		return productsFound;
	}

	@Override
	public List<Product> findProductByStatus(String status) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getStatus().equalsIgnoreCase(status)){
				productsFound.add(product);
			}
		return productsFound;
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getCategory().equalsIgnoreCase(category)){
				productsFound.add(product);
			}
		return productsFound;
	}

	@Override
	public List<Product> findProductByPrice(int price) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getCurrentPrice() == (price)){
				productsFound.add(product);
			}
		
		return productsFound;
	}

	@Override
	public List<Product> findProductByDescriptionLike(String description) {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getDescription().equalsIgnoreCase(description)){
				productsFound.add(product);
			}
		return productsFound;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts()){
			productsFound.add(product);
		}
		return productsFound;
	}

	@Override
	public void removeProduct(Product product) {
		testData.getProducts().remove(product);

	}
	
	@Override
	public void updateProduct(Product product) {
		testData.getProducts();
		for (Product productOld : testData.getProducts()){
			if (product.getProductID()==productOld.getProductID()){
				productOld= product;
			}
		}
		
	}
	
	@Override
	public Product findProductByPId(long productID){
		Product productFound = new Product();
		for (Product product : testData.getProducts())
			if (product.getProductID()==(productID)){
				productFound = product;
				break;
			}
		return productFound;		
	}
	
//	No longer using PID like - could potentially return all products. see ProductManager
//	@Override
//	public List<Product> findProductByPIdLike(long productID){
//		List<Product> productsFound = new ArrayList<Product>();
//		for (Product product : testData.getProducts())
//			if (product.getProductID()==(productID)){
//				productsFound.add(product);
//			}
//		return productsFound;		
//	}
	
	@Override
	public List<Product> findProductBySId(long stockID){
		List<Product> productsFound = new ArrayList<Product>();
		for (Product product : testData.getProducts())
			if (product.getProductID()==(stockID)){
				productsFound.add(product);
			}
		return productsFound;
	}
}
