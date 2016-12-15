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
		
		List <PurchaseOrder> purchaseOrderList = testdata.getPurchaseOrders();
		
		purchaseOrder.setId(purchaseOrderList.size()+1);
		
		purchaseOrderList.add(purchaseOrder);
		
		testdata.setPurchaseOrders(purchaseOrderList);
			
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		List <PurchaseOrder> purchaseOrderList = testdata.getPurchaseOrders();
		
			for(PurchaseOrder order : purchaseOrderList)
			{
				if (order.getId() == purchaseOrder.getId())
				{
					order = purchaseOrder;
				}
			}
			
			testdata.setPurchaseOrders(purchaseOrderList);
	}

	@Override
	public void createOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		purchaseOrderLine.setPurchaseOrderId(purchaseOrder.getOrderLines().size()+1);
		
		purchaseOrderLineList.add(purchaseOrderLine);
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);

	}

	@Override
	public void removeOrderline(PurchaseOrder purchaseOrder, int purchaseOrderLineNo) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		for(PurchaseOrderLine orderLineList : purchaseOrderLineList)
			if(orderLineList.getPurchaseOrderId() == purchaseOrderLineNo)
				purchaseOrderLineList.remove(purchaseOrderLineNo);
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);
		
	}

	@Override
	public void updateOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		
		List <PurchaseOrderLine> purchaseOrderLineList = purchaseOrder.getOrderLines();
		
		for(PurchaseOrderLine orderLineList : purchaseOrderLineList)
			if(orderLineList.getPurchaseOrderId() == purchaseOrderLine.getPurchaseOrderId())
				purchaseOrderLineList.remove(purchaseOrderLine.getLineNumber());
		
		purchaseOrder.setOrderLines(purchaseOrderLineList);
		
	}

	@Override
	public PurchaseOrder findPurchaseOrderByDate(Date date) {
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrders())
			if(purchaseorder.getDateAdded().equals(date))
			return purchaseorder;
			return null;
	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		List<PurchaseOrder>purchaseOrderList = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrders())
		{
			purchaseOrderList.add(purchaseorder);
		}
			return purchaseOrderList;
	}

	@Override
	public PurchaseOrder findPurchaseByEmployee(int employeeId) {
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrders())
			if(purchaseorder.getEmployeeId().equals(employeeId))
			return purchaseorder;
		return null;
	}
	
	/**
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	@Override
	public PurchaseOrder findPurchaseOrderById(int iId) {
		
		for(PurchaseOrder order: testData.getPurchaseOrders()) {
			
			if(order.getId() == iId) {
				
				return order;
				
			}
			
		}			
		
		// Returns null if not found
		//TODO Check appropriateness of this
		return null;
	}

}
