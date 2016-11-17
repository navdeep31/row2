package jar;

import java.time.LocalDate;

public interface ProductManager {

	public Product createNewProduct(Product product);
	
	public Product updateProduct();
	
	public Product findProductByName(String name);
	
	public Product findProductByDate(LocalDate date);
	
	public Product findProductByStatus(String status);
	
	public Product findProductByCategory(String category);
	
	public Product findProductByPrice(int price);
	
	public Product findProductByDescription(String description);
	
	public Product findAllProducts();
	
	public void removeProduct();

	


}
