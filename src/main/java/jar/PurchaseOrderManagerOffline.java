package jar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Stateless
@Default
public class PurchaseOrderManagerOffline implements PurchaseOrderManager {

	@Inject
	private TestData testdata;
	
	@Override
	public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
		List<PurchaseOrder> purchaseOrderList;
		purchaseOrderList.add(purchaseOrder);
		
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		List<PurchaseOrder> purchaseOrderList;
			for(PurchaseOrder order : purchaseOrderList)
			{
				if (order.getId() == purchaseOrder.getId())
				{
					order = purchaseOrder;
				}
			}
		
	}

	@Override
	public void createOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderline(PurchaseOrder purchaseOrder, int purchaseOrderLineNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderline(PurchaseOrder purchaseOrder, PurchaseOrderLine purchaseOrderLine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PurchaseOrder findPurchaseOrderByDate(Date date) {
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrder())
			if(purchaseorder.getDate().equals(date))
			return purchaseorder;
			return null;
	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		List<PurchaseOrder>purchaseOrderList = new ArrayList<PurchaseOrder>();
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrder())
		{
			purchaseOrderList.add(purchaseorder);
		}
			return purchaseOrderList;
		return null;
	}

	@Override
	public PurchaseOrder findPurchaseByEmployee(int employeeId) {
		for(PurchaseOrder purchaseorder: testdata.getPurchaseOrder())
			if(purchaseorder.getEmployeeId().equals(employeeId))
			return purchaseorder;
		return null;
	}

}
