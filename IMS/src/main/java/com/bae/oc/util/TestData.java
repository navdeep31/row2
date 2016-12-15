package com.bae.oc.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bae.oc.entities.Employee;
import com.bae.oc.entities.Stock;
import com.bae.oc.enums.ProductStatus;

@Startup
@Singleton
public class TestData {

	List<Stock> stock;
	List<Employee> employees;
	
	@PostConstruct
	private void setupData(){
		
	List<Stock> stock = new ArrayList<>();
	List<Employee> employees = new ArrayList<>();
		
		
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
	
	}

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
	
	
}
