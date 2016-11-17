package jar;

import java.util.Date;
import java.util.List;

public interface PurchaseOrderManager {
	
	void createPurchaseOrder(PurchaseOrder purchaseOrder);

	void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	void createOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine);

	void removeOrderline(PurchaseOrder purchaseOrder, int purchaseOrderLineNo);

	void updateOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine);

	PurchaseOrder findPurchaseOrderByDate(Date date);

	List<PurchaseOrder> findAllPurchaseOrders();

	PurchaseOrder findPurchaseByEmployee(int employeeId);

}
