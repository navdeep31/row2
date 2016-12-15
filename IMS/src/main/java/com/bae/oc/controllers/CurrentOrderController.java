package com.bae.oc.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentOrder;
import com.bae.oc.controllers.session.SelectedOrder;
import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.entities.Address;
import com.bae.oc.entities.Employee;
import com.bae.oc.entities.PurchaseOrderLine;
import com.bae.oc.services.OrderService;

@Named("current")
@RequestScoped
public class CurrentOrderController {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	@Inject
	private CurrentOrder order;
	
	@Inject
	private SelectedProduct product;
	
	@Inject
	private OrderService orderService;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private List<String> quantities;
	private int newQuantity;
	private int lineToRemove;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	public String update() {
		
		for(String quantity: quantities) {
			if(!quantity.isEmpty()) {
				order.setOrder(orderService.update(order.getOrder(), quantities));
				return "currentOrder";
			}
		}
		
		return "currentOrder";
		
	}
	
	public List<String> getQuantities() {
		int numberOfLines = order.getOrder().getOrderLines().size();
		
	}

}
