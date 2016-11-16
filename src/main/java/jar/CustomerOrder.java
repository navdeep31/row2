package jar;

public class CustomerOrder {
	
	private int id;
	private List<CustomerOrderLine> orderLines;
	private Address deliveryAddress;
	private Address billingAddress;
	
	private static int idCount = 1;
	
	CustomerOrder()
	{
		
	}
	
	CustomerOrder(List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress)
	{
		this.id = idCount++;
		this.orderLines = iOrderLines;
		this.deliveryAddress = iDeliveryAddress;
		this.billingAddress = iBillingAddress;
	}
	
	CustomerOrder(int iId, List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress)
	{
		this.id = iId;
		//TODO Logic to check non-conflicting id?
		this.orderLines = iOrderLines;
		this.deliveryAddress = iDeliveryAddress;
		this.billingAddress = iBillingAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int iId) {
		this.id = iId;
		//TODO Check non-conflicting?
	}

	public List<CustomerOrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<CustomerOrderLine> iOrderLines) {
		this.orderLines = iOrderLines;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address iDeliveryAddress) {
		this.deliveryAddress = iDeliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address iBillingAddress) {
		this.billingAddress = iBillingAddress;
	}

	public static int getIdCount() {
		return idCount;
	}

	public static void setIdCount(int iIdCount) {
		CustomerOrder.idCount = iIdCount;
	}
	


}
