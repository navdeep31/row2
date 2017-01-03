package com.bae.ims.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bae.ims.entities.Address;
import com.bae.ims.entities.Employee;
import com.bae.ims.entities.Product;
import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.entities.Stock;
import com.bae.ims.enums.ProductStatus;

@Startup
@Singleton
public class TestData {
	
	//////////////////////////////////////////ATTRIBUTES/////////////////////////////////////////

	private List<Stock> stock;
	private List<Employee> employees;
	private List<Product> products;
	private List<PurchaseOrder> orders;
	private List<Address> addresses;
	
	////////////////////////////////////////POST CONSTRUCT///////////////////////////////////////
	
	@PostConstruct
	private void setupData(){
		
	stock = new ArrayList<Stock>();
	employees = new ArrayList<Employee>();
	products = new ArrayList<Product>();
	orders = new ArrayList<PurchaseOrder>();
	addresses = new ArrayList<Address>();
		
		
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

	employees.add(new Employee(0, "Bill", "hello@email.com", "qwerty"));
		employees.add(new Employee(1, "Al", "yes@email.com", "12345"));
	
	products.add(new Product(1l,1l,"Kimberley Gnome","Scotland's finest Kimberley gnome", 12, 1999, 1699, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(2l,2l,"Garden Gnome","Our famous original garden gnome", 8, 1599, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(3l,3l,"Fishing Gnome","Gone fishin", 8, 1590, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(4l,4l,"Deluxe Hot Tub","NOTE: Is not a time machine", 3, 49999, 45999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(5l,5l,"Hot Tub Time Machine","Note: Is a time machine", 1, 55999, 51299, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(6l,6l,"Bubbletron 3000","BUBBLEZ!", 0, 31999, 30999, ProductStatus.DISCONTINUED, LocalDate.of(2016, Month.DECEMBER, 7), "Hot Tub"));
		products.add(new Product(7l,7l,"Rose Bush","Roses are red...", 0, 1599, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(8l,8l,"20x Violets","Violets are blue...", 5, 1799, 1299, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(9l,9l,"10x Fuchsia","I can see into the fuchsia", 15, 1999, 1699, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Plants"));
		products.add(new Product(10l,10l,"Pitchfork","TODO Pitchfork instructions", 6, 2499, 1999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(11l,11l,"Garden Trowel","TODO Garden Trowel", 0, 1399, 1099, ProductStatus.ON_HOLD, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(12l,12l,"Rake","TODO Rake description", 12, 1199, 999, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		products.add(new Product(13l,13l,"Garden Gloves","TODO Garden Glove description", 6, 1499, 1499, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Equipment"));
		
		addresses.add(new Address("2 Example Drive", "EX1 8LE", "Atlantis"));
		addresses.add(new Address("30 Testing Road", "GN2 8ME", "Debug City"));
		
		orders.add(new PurchaseOrder(1, employees.get(0), addresses.get(0), LocalDate.of(2012, Month.JANUARY, 10)));
		
		//TODO Add example purchase orders
	
	}
	
	///////////////////////////////////////////////METHODS//////////////////////////////////

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<PurchaseOrder> getOrders() {
		return this.orders;
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

	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}
	
	
	
}
