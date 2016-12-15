package com.bae.oc.managers;

import java.util.Date;
import java.util.List;

import com.bae.oc.entities.PurchaseOrder;
import com.bae.oc.entities.PurchaseOrderLine;

public interface PurchaseOrderManager {
	
	void createPurchaseOrder(PurchaseOrder purchaseOrder);

	void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	void createOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine);

	void removeOrderline(PurchaseOrder purchaseOrder, int purchaseOrderLineNo);

	void updateOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine);

	PurchaseOrder findPurchaseOrderByDate(Date date);

	List<PurchaseOrder> findAllPurchaseOrders();

	PurchaseOrder findPurchaseByEmployee(int employeeId);
	
	PurchaseOrder findOrderById(int iId);

}
