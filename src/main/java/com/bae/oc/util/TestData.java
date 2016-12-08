package com.bae.oc.util;

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
		setProducts(new ArrayList<>());
		setStocks(new ArrayList<>());
		setCustomers(new ArrayList<>());
		setEmployees(new ArrayList<>());
		setPurchaseOrders(new ArrayList<PurchaseOrder>());
		
		
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
