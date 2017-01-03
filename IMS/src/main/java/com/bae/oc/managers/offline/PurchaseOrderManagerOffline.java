package com.bae.oc.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.PurchaseOrderLine;
import com.bae.oc.managers.PurchaseOrderManager;
import com.bae.oc.util.TestData;

@Stateless
@Default
public class PurchaseOrderManagerOffline implements PurchaseOrderManager {

	@Inject
	private TestData testData;
	
	@Override
	public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
		
		List <PurchaseOrder> purchaseOrderList = testData.getOrders();
		
		purchaseOrder.setId(purchaseOrderList.size()+1);
		
		purchaseOrderList.add(purchaseOrder);
		
		testData.setOrders(purchaseOrderList);
			
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		List <PurchaseOrder> purchaseOrderList = testData.getOrders();
		
			for(PurchaseOrder order : purchaseOrderList)
			{
				if (order.getId() == purchaseOrder.getId())
				{
					order = purchaseOrder;
				}
			}
			
			testData.setOrders(purchaseOrderList);
	}

	@Override
	public void createOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		purchaseOrderLine.setLineNumber(purchaseOrder.getOrderLines().size()+1);
		
		purchaseOrderLineList.add(purchaseOrderLine);
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);

	}

	@Override
	public void removeOrderline(PurchaseOrder purchaseOrder, int purchaseOrderLineNo) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		for(PurchaseOrderLine orderLineList : purchaseOrderLineList)
			if(orderLineList.getLineNumber() == purchaseOrderLineNo)
				purchaseOrderLineList.remove(purchaseOrderLineNo);
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);
		
	}

	@Override
	public void updateOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		for(PurchaseOrderLine orderLineList : purchaseOrderLineList)
			if(orderLineList.getLineNumber() == purchaseOrderLine.getLineNumber())
				purchaseOrderLineList.remove(purchaseOrderLine.getLineNumber());
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);
		
	}

	@Override
	public PurchaseOrder findPurchaseOrderByDate(Date date) {
		for(PurchaseOrder purchaseorder: testData.getOrders())
			if(purchaseorder.getDateAdded().equals(date))
			return purchaseorder;
			return null;
	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		List<PurchaseOrder>purchaseOrderList = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder purchaseorder: testData.getOrders())
		{
			purchaseOrderList.add(purchaseorder);
		}
			return purchaseOrderList;
	}

	@Override
	public PurchaseOrder findPurchaseByEmployee(int employeeId) {
		for(PurchaseOrder purchaseorder: testData.getOrders())
			if(purchaseorder.getEmployee().getId() ==(employeeId))
			return purchaseorder;
		return null;
	}
	
	/**
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public PurchaseOrder findOrderById(int iId) {
		
		for(PurchaseOrder order: testData.getOrders()) {
			
			if(order.getId() == iId) {
				
				return order;
				
			}
			
		}			
		
		// Returns null if not found
		//TODO Check appropriateness of this
		return null;
	}

}
