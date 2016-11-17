package jar;

import java.time.LocalDate;

public interface CustomerManager {
	public Customer findByEmail(String email);
	public void createNewCustomer(Customer customer);
	public Customer orderBySurname(String lastname);
	public Customer orderByDate(LocalDate dateAdded);
	public void updateCustomer(Customer customer);
	public void addToWishList(Product product, Customer customer);
	public void removeFromWishList(Product product, Customer customer);
}
