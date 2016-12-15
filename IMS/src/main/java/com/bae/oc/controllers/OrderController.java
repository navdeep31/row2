package com.bae.oc.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.SelectedOrder;
import com.bae.oc.entities.Address;
import com.bae.oc.entities.Employee;
import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.PurchaseOrderLine;

/**
 * Deals with viewing SelectedOrder
 * 
 * @author Alex Dawson
 *
 */
@Named("order")
@RequestScoped
public class OrderController {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	@Inject
	private SelectedOrder order;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private List<PurchaseOrderLine> orderLines;
	private Employee employee;
	private Address deliveryAddress;
	private LocalDate dateAdded;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	public List<String> getNames() {
	}
	
}
