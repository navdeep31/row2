package com.bae.oc.util;

import java.time.LocalDate;
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
		
		products.add(new Product(1l,1l,"Kimberley Gnome","Scotland's finest Kimberley gnome", 12, 19.99, 16.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(2l,2l,"Garden Gnome","Our famous original garden gnome", 8, 15.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(3l,3l,"Fishing Gnome","Gone fishin", 8, 15.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(4l,4l,"Deluxe Hot Tub","NOTE: Is not a time machine", 3, 499.99, 459.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(5l,5l,"Hot Tub Time Machine","Note: Is a time machine", 1, 559.99, 512.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(6l,6l,"Bubbletron 3000","BUBBLEZ!", 0, 319.99, 309.99, ProductStatus.DISCONTINUED, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(7l,7l,"Rose Bush","Roses are red...", 0, 15.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(8l,8l,"20x Violets","Violets are blue...", 5, 17.99, 12.99, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(9l,9l,"10x Fuchsia","I can see into the fuchsia", 15, 19.99, 16.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(10l,10l,"Pitchfork","TODO Pitchfork instructions", 6, 24.99, 19.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(11l,11l,"Garden Trowel","TODO Garden Trowel", 0, 13.99, 10.99, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(12l,12l,"Rake","TODO Rake description", 12, 11.99, 9.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(13l,13l,"Garden Gloves","TODO Garden Glove description", 6, 14.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		
		
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
		customerOrderLine.add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.ORDER));
		customerOrder.get(1).setOrderLines(customerOrderLine);
		customerOrder.get(1).setStatus(Status.ORDER);
		
		customers.add(new Customer("Joe", "Bloggs", "j.bloggs@example.com", "qwerty", addresses.get(0)));
		customers.add(new Customer("Mr", "Robot", "elliot@fsociety.com", "password1", addresses.get(1)));
	
		customers.get(0).getOrders().add(new CustomerOrder());
		customers.get(0).getOrders().add(customerOrder.get(0));
		
		customers.get(1).getOrders().add(new CustomerOrder());
		customers.get(1).getOrders().add(customerOrder.get(1));
		
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
