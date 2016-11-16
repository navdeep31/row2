package jar;

import java.time.LocalDate;
import java.util.List;

import javax.mail.Address;

public class Customer {

	private long id;
	private String firstName;
	private String lastname;
	private String email;
	private String password;
	private LocalDate dateAdded;
	private Address address;
	private List<Product> wishlist;
	
	
	public Customer(String firstName, String lastname, String email, String password, Address address, LocalDate dateAdded) {
	//TODOconstructors
	}
	
	public Customer(long id, String firstName, String lastname, String email, String password, Address address, LocalDate dateAdded) {
	//TODOconstructors
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Product> wishlist) {
		this.wishlist = wishlist;
	}
	

	
}
