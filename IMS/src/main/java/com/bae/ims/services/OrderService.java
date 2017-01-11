package com.bae.ims.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.ims.entities.Product;
import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.entities.PurchaseOrderLine;
import com.bae.ims.managers.PurchaseOrderManager;

/**
 * Deals with business logic methods of single orders
 * 
 * @author Alex Dawson
 * @version 0.1 15/12/2016
 *
 */
@Stateless
public class OrderService {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	@Inject
	private PurchaseOrderManager orderManager;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Finds all purchase orders in data
	 * 
	 * @return List of Purchase Orders
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public List<PurchaseOrder> findAllOrders() {
		return orderManager.findAllPurchaseOrders();
	}
	
	/**
	 * Updates a purchase order with adjusted list of quantities
	 * 
	 * @param iOrder Purchase Order to update
	 * @param iQuantities String list of product quantities (with corresponding indices)
	 * @return Updated Purchase Order
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrder update(PurchaseOrder iOrder, List<String> iQuantities) {
		
		int numberOfLines = iOrder.getOrderLines().size();
		for (int i = 0; i < numberOfLines; i++) {
			
			//TODO Try catch format exception
			// If a line quantity is set, parse it to an int and set it to the relevant line in the order
			if(!iQuantities.get(i).isEmpty()) {
				iOrder.getOrderLines().get(i).setQuantity(Integer.parseInt(iQuantities.get(i)));
			}
			
		}
		
		orderManager.updatePurchaseOrder(iOrder);
		
		return iOrder;
		
	}
	
	public PurchaseOrder removeLine(PurchaseOrder iOrder, String iLineNumber) {
		
		//TODO Double check indexing
		
		//Removes order line with given index
		iOrder.getOrderLines().remove(Integer.parseInt(iLineNumber));
		
		orderManager.updatePurchaseOrder(iOrder);
		
		return iOrder;
		
	}
	
	public PurchaseOrder addLine(PurchaseOrder iOrder, Product iProduct, String iQuantity) {
		
		//Adds order line with given product and quantity
		iOrder.getOrderLines().add(new PurchaseOrderLine(iProduct, Integer.parseInt(iQuantity)));
		
		orderManager.updatePurchaseOrder(iOrder);
		
		return iOrder;
		
	}
	
	public void addNewOrder(PurchaseOrder iOrder) {
		orderManager.createPurchaseOrder(iOrder);
	}

}
