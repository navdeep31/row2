package jar;

import java.time.LocalDate;
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
	public Product createNewProduct(Product product) {
		List<Product> products = testData.getProducts();
		product.setProductID(products.size()+1);
		products.add(product);
		testData.setProducts(products);
		return findProductByName(product.getName());
		
	}

	@Override
	public Product updateProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductByName(String name) {
		for(Product product : testData.getProducts())
			if(product.getName().equalsIgnoreCase(name))
				return product;
		return null;
	}

	@Override
	public Product findProductByDate(LocalDate date) {
		for(Product product : testData.getProducts())
			if(product.getDateAdded().equals(date))
				return product;
		return null;
	}

	@Override
	public Product findProductByStatus(String status) {
		for(Product product : testData.getProducts())
			if(product.getStatus().equalsIgnoreCase(status))
				return product;
		return null;
	}

	@Override
	//TODO get category from mongo?
	public Product findProductByCategory(String category) {
		for(Product product : testData.getProducts())
			if(product.getCategory().equalsIgnoreCase(category))
				return product;
		return null;
	}

	@Override
	public Product findProductByPrice(int price) {
		for(Product product : testData.getProducts())
			if(product.getCurrentPrice()==(price))
				return product;
		return null;
	}

	@Override
	public Product findProductByDescription(String description) {
		for(Product product : testData.getProducts())
			if(product.getDescription().equalsIgnoreCase(description))
				return product;
		return null;
	}

	@Override
	public Product findAllProducts() {
		for(Product product : testData.getProducts())
			return product;
		return null;
	}

	@Override
	public void removeProduct() {
		// TODO Auto-generated method stub

	}

}
