package com.bae.oc.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;

import com.bae.oc.entities.Address;
import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;
import com.bae.oc.entities.Product;
import com.bae.oc.enums.ProductStatus;
import com.bae.oc.enums.Status;

@Startup
@Singleton
public class TestData {
	private List<Product> products;

	private List<Customer> customers;
	private List<Address> addresses;
	private List<CustomerOrderLine> customerOrderLine;
	private List<CustomerOrder> customerOrder;

	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		
		customers = new ArrayList<>();
		addresses = new ArrayList<>();
		customerOrder = new ArrayList<>();
		
		products.add(new Product(1l,1l,"Kimberley Gnome","Scotland's finest Kimberley gnome", 12, 1999, 1699, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(2l,2l,"Garden Gnome","Our famous original garden gnome", 8, 1599, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(3l,3l,"Fishing Gnome","Gone fishin", 8, 1599, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(4l,4l,"Deluxe Hot Tub","NOTE: Is not a time machine", 3, 49999, 45999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(5l,5l,"Hot Tub Time Machine","Note: Is a time machine", 1, 55999, 51299, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(6l,6l,"Bubbletron 3000","Generates 3000 bubbles a minute", 0, 31999, 30999, ProductStatus.DISCONTINUED, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(7l,7l,"Rose Bush","Roses are red...", 0, 1599, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(8l,8l,"20x Violets","Violets are blue...", 5, 1799, 1299, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(9l,9l,"10x Fuchsia","I can see into the fuchsia", 15, 1999, 1699, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(10l,10l,"Pitchfork","Get your torches and pitchforks!", 6, 2499, 1999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(11l,11l,"Garden Trowel","Dig a hole in the ground", 0, 1399, 1099, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(12l,12l,"Rake","Want to leave leaving leaves left around left in the past? Then get this rake!", 12, 1199, 999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(13l,13l,"Garden Gloves","Trouble with thorns? Not any more with these elegant gardening gloves made of cutting edge protective material", 6, 1499, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		
		
		addresses.add(new Address("2 Example Drive", "EX1 8LE", "Atlantis"));
		addresses.add(new Address("30 Testing Road", "GN2 8ME", "Debug City"));
		
		customerOrder.add(new CustomerOrder());
				
		customerOrderLine = new ArrayList<>();
		customerOrderLine.add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.BASKET));
		customerOrderLine.add(new CustomerOrderLine(1l,2 , products.get(5), 5, Status.BASKET));
		customerOrder.get(0).setOrderLines(customerOrderLine);
		customerOrder.get(0).setStatus(Status.BASKET);
		
		customerOrder.add(new CustomerOrder());
		
		customerOrderLine = new ArrayList<>();
		customerOrderLine.add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.ORDERED));
		customerOrder.get(1).setOrderLines(customerOrderLine);
		customerOrder.get(1).setStatus(Status.DELIVERED);
		
		customers.add(new Customer("Joe", "Bloggs", "j.bloggs@example.com", "qwerty", addresses.get(0)));
		customers.add(new Customer("Mr", "Robot", "elliot@fsociety.com", "password1", addresses.get(1)));
	
		
		customerOrder.get(0).setOrderDate(LocalDateTime.now());
		customerOrder.get(1).setOrderDate(LocalDateTime.now());
		
		customers.get(0).getOrders().add(new CustomerOrder());
		customers.get(0).getOrders().add(customerOrder.get(0));
		
		customers.get(1).getOrders().add(new CustomerOrder());
		customers.get(1).getOrders().add(customerOrder.get(1));
		
		customerOrder.get(0).getOrderLines().get(0).setStatus(Status.ORDERED);
		customerOrder.get(0).getOrderLines().get(1).setStatus(Status.ORDERED);
		customerOrder.get(0).setStatus(Status.DISPATCHED);
		
		customers.get(1).getOrders().add(customerOrder.get(0));
		
		// TODO Add Employee and PurchaseOrders data when IMS testing begins
		// setEmployees(new ArrayList<>());
		// setPurchaseOrders(new ArrayList<PurchaseOrder>());

		
		
	}
	// TODOgetters & setters

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}




	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	

	/**
	 * Returns the test data addresses
	 * 
	 * @return List of Addresses
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public List<Address> getAddresses() {
		return this.addresses;
	}
	
	/**
	 * Sets the test data addresses
	 * 
	 * @param iAddresses List of Addresses
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setAddresses(List<Address> iAddresses) {
		this.addresses = iAddresses;
	}
}
