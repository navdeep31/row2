package com.bae.oc.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Address;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.ws.RespectBinding;

/**
 * Represents a customer.
 * 
 * Includes orders (List of Customer Orders) as an attribute which is lazily fetched.
 * 
 * Includes wishlist (List of Products) as an attribute which is lazily fetche
 * 
 * @author Conor White
 * @author Alex Dawson
 *
 */
@Entity
@Table(name="customers")

@NamedQueries({
@NamedQuery(name="findByEmail", query= "SELECT c FROM customers c WHERE c.email=:email"),
@NamedQuery(name="orderBySurname", query= "SELECT c FROM customers c ORDER BY c.lastname"),
@NamedQuery(name="orderByDate", query= "SELECT c FROM customers c ORDER BY c.dateAdded")
})

public class Customer {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////

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
	private String lastName;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String email;
	
	@Column(nullable=false, length=255)
	@Size(max=255)
	@NotNull
	private String password;
	
	@ManyToOne
	@JoinColumn(name="addresses_id", nullable=false)
	@NotNull
	private Address address;
	
	//TODO Double check address database name / entity-ising
	
	@Column
	private LocalDate dateAdded;

	//TODO Double check database names
	
	@ManyToMany
	@JoinTable(name="wishlist", 
	joinColumns=
	@JoinColumn(name="customers_id", 
	referencedColumnName="id"), 
	inverseJoinColumns=
	@JoinColumn(name="product_id", referencedColumnName="id"))
	private List<Product> wishlist;
	
	@OneToMany
	@JoinTable(name="customer_order",
		joinColumns=
			@JoinColumn(name="customer_id", referencedColumnName="id")
	)
	private List<CustomerOrder> orders;
	
	private static int idCount = 0;
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Default constructor
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Customer() {
		
	}
	
	//TODO Write constructors for final attributes
	
	/**
	 * Constructor for new customer (without ID, date added, wishlist, orders)
	 * 
	 * Automatically sets ID count to next and date added to now.
	 * 
	 * @param iFirstName First Name
	 * @param iLastName Last Name
	 * @param iEmail Email
	 * @param iPassword Password
	 * @param iAddress Address
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Customer(String iFirstName, String iLastName, String iEmail, String iPassword, Address iAddress) {
		this(++idCount, iFirstName, iLastName, iEmail, iPassword, iAddress);
	}
	
	/**
	 * Constructor for new customer with fixed ID
	 * 
	 * @param iId Customer ID
	 * @param iFirstName First Name
	 * @param iLastName Last Name
	 * @param iEmail Email
	 * @param iPassword Password
	 * @param iAddress Address
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Customer(long iId, String iFirstName, String iLastName, String iEmail, String iPassword, Address iAddress) {
		this.id = iId;
		this.firstName = iFirstName;
		this.lastName = iLastName;
		this.email = iEmail;
		this.password = iPassword;
		this.address = iAddress;
		//TODO Add date now function
		this.wishlist = new ArrayList<Product>();
		this.orders = new ArrayList<CustomerOrder>();
	}
	
	/**
	 * Constructor with all attributes
	 * 
	 * @param iId Customer ID
	 * @param iFirstName First Name
	 * @param iLastName Last Name
	 * @param iEmail Email
	 * @param iPassword Password
	 * @param iAddress Address
	 * @param iDateAdded Date Customer Added to System
	 * @param iWishlist Wishlist (List of Products)
	 * @param iOrders List of Customer Orders
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Customer(long iId, String iFirstName, String iLastName, String iEmail, String iPassword, Address iAddress, LocalDate iDateAdded, List<Product> iWishlist, List<CustomerOrder> iOrders) {
		this.id = iId;
		this.firstName = iFirstName;
		this.lastName = iLastName;
		this.email = iEmail;
		this.password = iPassword;
		this.address = iAddress;
		this.dateAdded = iDateAdded;
		this.wishlist = iWishlist;
		this.orders = iOrders;
	}
	
	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	/**
	 * Returns First Name of Customer
	 * 
	 * @return First name
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets First Name of Customer
	 * 
	 * @param iFirstName First Name of Customer
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setFirstName(String iFirstName) {
		this.firstName = iFirstName;
	}

	/**
	 * Returns Last Name of Customer
	 * 
	 * @return Last Name of Customer
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets Last Name of Customer
	 * 
	 * @param iLastName Last Name of Customer
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setLastName(String iLastName) {
		this.lastName = iLastName;
	}

	/**
	 * Returns Customer Email
	 * 
	 * @return Customer Email
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets Customer Email
	 * 
	 * @param iEmail Customer Email
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setEmail(String iEmail) {
		this.email = iEmail;
	}

	/**
	 * Returns Customer Password
	 * 
	 * @return Customer Password
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets Customer Password
	 * 
	 * @param iPassword Customer Password
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setPassword(String iPassword) {
		this.password = iPassword;
	}

	/**
	 * Returns the date the Customer was registered
	 * 
	 * @return Registration Date
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public LocalDate getDateAdded() {
		return this.dateAdded;
	}

	//TODO Finish off comments
	
	/**
	 * Sets 
	 * 
	 * @param dateAdded
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * 
	 * @return
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Returns the wishlist (list of products) of a Customer
	 * 
	 * @return Wishlist (List of Products)
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public List<Product> getWishlist() {
		return this.wishlist;
	}

	/**
	 * Sets the Customer Wishlist to a given list of products
	 * 
	 * @param wishlist List of Products
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setWishlist(List<Product> wishlist) {
		this.wishlist = wishlist;
	}

	/**
	 * Returns the Customer ID
	 * 
	 * @return Customer ID
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the Customer ID
	 * 
	 * @param id Customer ID
	 * 
	 * @MethodAuthor Conor White
	 * @MethodAuthor Alex Dawson
	 */
	public void setId(long id) {
		this.id = id;
		//TODO Check non-negative?
	}
	
	/**
	 * Returns a list of the orders of a customer
	 * 
	 * @return List of Customer Orders
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public List<CustomerOrder> getOrders() {
		return this.orders;
	}
	
	/**
	 * Sets the list 
	 * 
	 * @param iOrders List of customer orders to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setOrders(List<CustomerOrder> iOrders) {
		this.orders = iOrders;
	}
	

	
}
