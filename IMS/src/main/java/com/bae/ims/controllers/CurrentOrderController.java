package com.bae.ims.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.ims.controllers.session.CurrentOrder;
import com.bae.ims.controllers.session.CurrentUser;
import com.bae.ims.controllers.session.SelectedProduct;
import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.enums.ProductStatus;
import com.bae.ims.services.OrderService;

/**
 * Deals with viewing and editing current order, as well as adding products to order
 * 
 * @author Alex Dawson
 *
 */
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
	
	@Inject
	private CurrentUser currentUser;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private List<String> quantities;
	private String newQuantity;
	private String lineToRemove;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	public void addSubmittedOrder() {
		order.getOrder().setEmployeeId(currentUser.getEmployee());
		order.getOrder().setDateAdded(LocalDate.now());
		orderService.addNewOrder(order.getOrder());
	}	
	
	public void createNewOrder() {
		order.setOrder(null);
	}
	
	public String redirect(){
		if(currentUser.isLoggedIn() == false){
		return "login";
		}
		return null;
	}
	
	/**
	 * Updates (the quantities of) the current order
	 * 
	 * @return String of next page to visit
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String update() {
		
		for(String quantity: quantities) {
			if(!quantity.isEmpty()) {
				order.setOrder(orderService.update(order.getOrder(), quantities));
				return "currentOrder";
			}
		}
		
		return "currentOrder";
		
	}
	
	/**
	 * Removes the order line with number "lineToRemove" of the current order
	 * 
	 * @return String of the next page to visit
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String removeLine() {
		
		order.setOrder(orderService.removeLine(order.getOrder(), lineToRemove));
		
		return "currentOrder";
	}
	
	/**
	 * Add an order line of selected product and new quantity to the order
	 * 
	 * @return String of the next page to visit
	 */
	public void addLine() {
		
		if (order.getOrder() == null){
			order.setOrder(new PurchaseOrder());
		}
		
		if (product.getProduct().getStatus() == ProductStatus.DISCONTINUED) {
			
		}
		else
		{
		order.setOrder(orderService.addLine(order.getOrder(), product.getProduct(), newQuantity));
		}		
		// return "products";
		
	}
	
	public List<String> getQuantities() {
		
		int numberOfLines = order.getOrder().getOrderLines().size();
		
		if(numberOfLines != quantities.size()) {
			
			quantities = new ArrayList<String>(numberOfLines);
			
		}
			
		for (int i = 0; i < numberOfLines; i++) {
			
			if(!quantities.get(i).isEmpty()) {
				
				quantities.set(i, String.valueOf(order.getOrder().getOrderLines().get(i).getQuantity()));
				
			}
			
		}
		
		return quantities;
		
	}
	
	public void setQuantities(List<String> iQuantities) {
		this.quantities = iQuantities;
	}
	
	public String getNewQuantity() {
		return this.newQuantity;
	}
	
	public void setNewQuantity(String iQuantity) {
		this.newQuantity = iQuantity;
	}
	
	public String getLineToRemove() {
		return this.lineToRemove;
	}
	
	public void setLineToRemove(String iLineToRemove) {
		this.lineToRemove = iLineToRemove;
	}

}
