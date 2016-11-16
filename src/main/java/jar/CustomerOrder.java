package jar;

import java.util.*;

/**
 * Represents a customer order, using a list of customer order lines
 * 
 * @author Alex Dawson
 * @version 0.2 16/11/2016
 *
 */
public class CustomerOrder {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
	private int id;
	private List<CustomerOrderLine> orderLines;
	private Address deliveryAddress;
	private Address billingAddress;
	
	private static int idCount = 0;
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Default constructor
	 */
	CustomerOrder()
	{
		//TODO Keep this or not?
	}
	
	/**
	 * Constructor without id. Automatically sets id as next idCount
	 * 
	 * @param iOrderLines List of Order Lines
	 * @param iDeliveryAddress Delivery Address (Address Object)
	 * @param iBillingAddress Billing Address (Address Object)
	 */
	CustomerOrder(List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress)
	{
		this.id = ++idCount;
		this.orderLines = iOrderLines;
		this.deliveryAddress = iDeliveryAddress;
		this.billingAddress = iBillingAddress;
	}
	
	/**
	 * Constructor with id.
	 * 
	 * @param iId Customer Order ID
	 * @param iOrderLines List of Order Lines
	 * @param iDeliveryAddress Delivery Address (Address Object)
	 * @param iBillingAddress Billing Address (Address Object)
	 */
	CustomerOrder(int iId, List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress)
	{
		this.id = iId;
		//TODO Logic to check non-conflicting id?
		this.orderLines = iOrderLines;
		this.deliveryAddress = iDeliveryAddress;
		this.billingAddress = iBillingAddress;
	}

	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

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
