package jar;
import java.time.LocalDate;
import java.util.List;

import javax.mail.Address;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String firstName;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String lastname;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String email;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String password;
	
	@Column
	private LocalDate dateAdded;
	
	@ManyToOne
	@JoinColumn(name="addresses_id", nullable=false)
	@NotNull
	private Address address;
<<<<<<< HEAD
	
	@ManyToMany
	@JoinTable(name="wishlist", 
	joinColumns=@JoinColumn(name="customers_id", 
	referencedColumnName="id"), 
	inverseJoinColumns=
	@JoinColumn(name="stock_id", 
	referencedColumnName="id"))
	private List<Stock> wishlist;
=======
	private List<Product> wishlist;
>>>>>>> e8243b3678eb4f1aaa3cf02b3c657a0e36ffc225
	
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	
}
