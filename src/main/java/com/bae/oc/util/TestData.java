package com.bae.oc.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;

import com.bae.oc.entities.Address;
import com.bae.oc.entities.Customer;
import com.bae.oc.entities.Employee;
import com.bae.oc.entities.Product;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.Stock;
import com.bae.oc.enums.ProductStatus;

@Startup
@Singleton
public class TestData {
	private List<Product> products;
	private List<Stock> stocks;
	private List<Customer> customers;
	private List<Employee> employees;
	private List<PurchaseOrder> purchaseOrders;
	private List<Address> addresses;

	@PostConstruct
	private void setupData() {
		products = new ArrayList<>();
		stocks = new ArrayList<>();
		customers = new ArrayList<>();
		addresses = new ArrayList<>();
		
		products.add(new Product(1l,1l,"Kimberley Gnome","Scotland's finest Kimberley gnome", 12, 19.99, 16.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(2l,2l,"Garden Gnome","Our famous original garden gnome", 8, 15.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		products.add(new Product(3l,3l,"Fishing Gnome","Gone fishin", 8, 15.99, 14.99, ProductStatus.AVALIABLE, LocalDate.of(2016, Month.DECEMBER, 7), "Gnome"));
		
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
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
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
