package jar;

import java.time.LocalDate;
import java.util.List;

public interface ProductManager {

	public Product createNewProduct(Product product);
	
	public Product updateProduct();
	
	public List<Product> findProductByName(String name);
	
	public List<Product> findProductByDate(LocalDate date);
	
	public List<Product> findProductByStatus(String status);
	
	public List<Product> findProductByCategory(String category);
	
	public List<Product> findProductByPrice(int price);
	
	public List<Product> findProductByDescription(String description);
	
	public List<Product> findAllProducts();
	
	public void removeProduct();

	


}
