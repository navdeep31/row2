package jar;

import java.time.LocalDate;

public interface CustomerManager {
	public Customer findByEmail(String email);
	public Customer createNewCustomer(Customer customer);
	public Customer orderBySurname(String lastname);
	public Customer orderByDate(LocalDate dateAdded);
	public Customer updateCustomer(Customer customer);
	public Customer addToWishList(Product id);
	public Customer removeFromWishList(Product id);
}
