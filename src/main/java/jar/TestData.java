package jar;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;

@Startup
@Singleton
public class TestData{
private List<Product> products;
private List<Stock> stocks;
private List<Customer> customers;
private List<Employee> employees;
private List<PurchaseOrder> purchaseOrders;

@PostConstruct
private void setupData() {
setProducts(new ArrayList<>());
setStocks(new ArrayList<>());
setCustomers(new ArrayList<>());
setEmployees(new ArrayList<>()); 
//TODOadd data
}
//TODOgetters & setters

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

public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
	this.purchaseOrders = purchaseOrders;
}

}

