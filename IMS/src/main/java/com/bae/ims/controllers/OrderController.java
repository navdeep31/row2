package com.bae.ims.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.ims.controllers.session.CurrentOrder;
import com.bae.ims.controllers.session.SelectedOrder;
import com.bae.ims.entities.Address;
import com.bae.ims.entities.Employee;
import com.bae.ims.entities.PurchaseOrder;
import com.bae.ims.entities.PurchaseOrderLine;
import com.bae.ims.services.OrderService;

/**
 * Deals with viewing SelectedOrder
 * 
 * Implemented with attributes to be ready for change (editing)
 * 
 * @author Alex Dawson
 *
 */
@Named("order")
@RequestScoped
public class OrderController {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	@Inject
	private SelectedOrder selectedOrder;
	@Inject
	private CurrentOrder currentOrder;
	@Inject
	private OrderService orderService;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private List<PurchaseOrderLine> orderLines;
	private PurchaseOrder order;
	private Employee employee;
	private Address deliveryAddress;
	private LocalDate dateAdded;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	
}
