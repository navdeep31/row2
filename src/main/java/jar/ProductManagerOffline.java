package jar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

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
	public List<Product> findProductByName(String name) {
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
	// TODO get category from mongo?
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
	public List<Product> findProductByDescription(String description) {
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

}
