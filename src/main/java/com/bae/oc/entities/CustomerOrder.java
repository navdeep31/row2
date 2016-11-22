package com.bae.oc.entities;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Represents a customer order, using a list of customer order lines
 * 
 * @author Alex Dawson
 * @version 0.3 16/11/2016
 *
 */
@Entity
@Table(name="customer_order")
@NamedQueries({
	@NamedQuery(name="CustomerOrder.findAll", query="SELECT co FROM customer_order co"),
	@NamedQuery(name="CustomerOrder.findByCustomer", query="SELECT co FROM customer_order co WHERE co.customer_id = :id")
})
public class CustomerOrder {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinTable(name="customer_order_lines",
		joinColumns=
			@JoinColumn(name="customer_order_id", referencedColumnName="id")
	)
	private List<CustomerOrderLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@NotNull
	private Address deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@NotNull
	private Address billingAddress;
	
	private static int idCount = 0;
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Default constructor
	 */
	CustomerOrder() {
		//TODO Keep this or not?
	}
	
	/**
	 * Constructor without id. Automatically sets id as next idCount
	 * 
	 * @param iOrderLines List of Order Lines
	 * @param iDeliveryAddress Delivery Address (Address Object)
	 * @param iBillingAddress Billing Address (Address Object)
	 */
	CustomerOrder(List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress) {
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
	CustomerOrder(int iId, List<CustomerOrderLine> iOrderLines, Address iDeliveryAddress, Address iBillingAddress) {
		this.id = iId;
		//TODO Logic to check non-conflicting id?
		this.orderLines = iOrderLines;
		this.deliveryAddress = iDeliveryAddress;
		this.billingAddress = iBillingAddress;
	}

	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	/**
	 * Returns Customer Order ID
	 * 
	 * @return Customer Order ID
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets Customer Order ID
	 * 
	 * @param iId Customer Order ID to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setId(int iId) {
		this.id = iId;
		//TODO Check non-conflicting?
	}

	/**
	 * Returns ArrayList of Order Lines
	 * 
	 * @return Order Lines (ArrayList)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public List<CustomerOrderLine> getOrderLines() {
		return new ArrayList<CustomerOrderLine>(orderLines);
	}

	/**
	 * Sets List of Order Lines
	 * 
	 * @param iOrderLines List of Order Lines
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setOrderLines(List<CustomerOrderLine> iOrderLines) {
		this.orderLines = iOrderLines;
	}

	/**
	 * Returns Delivery Address (Address Object)
	 * 
	 * @return Delivery Address (Address Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Sets Delivery Address (Address Object)
	 * 
	 * @param iDeliveryAddress Delivery Address to set (Address Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setDeliveryAddress(Address iDeliveryAddress) {
		this.deliveryAddress = iDeliveryAddress;
	}

	/**
	 * Returns Billing Address (Address Object)
	 * 
	 * @return Billing Address (Address Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Sets Billing Address (Address Object)
	 * 
	 * @param iBillingAddress Billing Address to set (Address Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setBillingAddress(Address iBillingAddress) {
		this.billingAddress = iBillingAddress;
	}

	/**
	 * Returns ID Count
	 * 
	 * @return ID Count
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public static int getIdCount() {
		return idCount;
	}

	/**
	 * Sets ID Count
	 * 
	 * @return ID Count to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public static void setIdCount(int iIdCount) {
		CustomerOrder.idCount = iIdCount;
	}
	


}
