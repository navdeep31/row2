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
import com.bae.oc.entities.Employee;
import com.bae.oc.entities.Product;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.Stock;
import com.bae.oc.enums.ProductStatus;
import com.bae.oc.enums.Status;

@Startup
@Singleton
public class TestData {
	private List<Product> products;
	private List<Stock> stock;
	private List<Customer> customers;
	private List<Employee> employees;
	private List<PurchaseOrder> purchaseOrders;
	private List<Address> addresses;
	private List<CustomerOrderLine> customerOrderLine;
	private List<CustomerOrder> customerOrder;

	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		stock = new ArrayList<>();
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
		
		stock.add(new Stock(1l, ProductStatus.AVALIABLE));
		stock.add(new Stock(2l, ProductStatus.AVALIABLE));
		stock.add(new Stock(3l, ProductStatus.AVALIABLE));
		stock.add(new Stock(4l, ProductStatus.AVALIABLE));
		stock.add(new Stock(5l, ProductStatus.AVALIABLE));
		stock.add(new Stock(6l, ProductStatus.DISCONTINUED));
		stock.add(new Stock(7l, ProductStatus.AVALIABLE));
		stock.add(new Stock(8l, ProductStatus.ON_HOLD));
		stock.add(new Stock(9l, ProductStatus.AVALIABLE));
		stock.add(new Stock(10l, ProductStatus.AVALIABLE));
		stock.add(new Stock(11l, ProductStatus.ON_HOLD));
		stock.add(new Stock(12l, ProductStatus.AVALIABLE));
		stock.add(new Stock(13l, ProductStatus.AVALIABLE));
		
		addresses.add(new Address("2 Example Drive", "EX1 8LE", "Atlantis"));
		addresses.add(new Address("30 Testing Road", "GN2 8ME", "Debug City"));
		
		customerOrder.add(new CustomerOrder());
		
		customerOrder.get(0).getOrderLines().add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.BASKET));
		customerOrder.get(0).getOrderLines().add(new CustomerOrderLine(2l,2 , products.get(1), 1, Status.BASKET));
		customerOrder.get(0).getOrderLines().add(new CustomerOrderLine(11l,3 , products.get(10), 1, Status.BASKET));
		
		customerOrder.add(new CustomerOrder());
		
	//	customerOrder.get(1).getOrderLines().add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.ORDER));
	//	customerOrder.get(1).getOrderLines().add(new CustomerOrderLine(2l,2 , products.get(1), 1, Status.ORDER));
	//	customerOrder.get(1).getOrderLines().add(new CustomerOrderLine(11l,3 , products.get(10), 1, Status.ORDER));
		
		customerOrderLine = new ArrayList<>();
		customerOrderLine.add(new CustomerOrderLine(1l,1 , products.get(0), 2, Status.ORDER));
		customerOrder.get(1).setOrderLines(customerOrderLine);
		customerOrder.get(1).setStatus(Status.ORDER);
		
		customers.add(new Customer(1l, "Joe", "Bloggs", "j.bloggs@example.com", "qwerty", addresses.get(0)));
		customers.add(new Customer(2l, "Mr", "Robot", "elliot@fsociety.com", "password1", addresses.get(1)));
	
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

	public List<Stock> getStocks() {
		return stock;
	}

	public void setStocks(List<Stock> stocks) {
		this.stock = stocks;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	
	public void setPurchaseOrders(List<PurchaseOrder> iPurchaseOrders)
	{
		this.purchaseOrders = iPurchaseOrders;
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
