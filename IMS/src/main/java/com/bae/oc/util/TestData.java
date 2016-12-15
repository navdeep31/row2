package com.bae.oc.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bae.oc.entities.Employee;
import com.bae.oc.entities.Product;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.Stock;
import com.bae.oc.enums.ProductStatus;

@Startup
@Singleton
public class TestData {
	
	//////////////////////////////////////////ATTRIBUTES/////////////////////////////////////////

	List<Stock> stock;
	List<Employee> employees;
	List<Product> products;
	List<PurchaseOrder> orders;
	
	////////////////////////////////////////POST CONSTRUCT///////////////////////////////////////
	
	@PostConstruct
	private void setupData(){
		
	stock = new ArrayList<Stock>();
	employees = new ArrayList<Employee>();
	products = new ArrayList<Product>();
	orders = new ArrayList<PurchaseOrder>();
		
		
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
	
	
	
	
}
