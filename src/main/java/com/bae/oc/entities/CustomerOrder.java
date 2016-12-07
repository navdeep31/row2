package com.bae.oc.entities;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.bae.oc.enums.Status;

/**
 * Represents a customer order, using a list of customer order lines
 * 
 * @author Alex Dawson
 * @version 0.4 22/11/2016
 * 
 * @author Tim Spencer
 * @author Andrew Claybrook
 * @version 0.5 06/12/2016 
 * Added status to order
 */
@Entity
@Table(name="customer_order")
@NamedQueries({
	@NamedQuery(name="CustomerOrder.findAll", query="SELECT co FROM customer_order co"),
	@NamedQuery(name="CustomerOrder.findByCustomer", query="SELECT co FROM customer_order co WHERE co.customer_id = :id"),
	@NamedQuery(name="CustomerOrder.findByStatus", query="SELECT co FROM customer_order co WHERE co.status = :status"),
	
	/**
	 * @author Tim Spencer
	 * @author Andrew Claybrook
	 * Code needs examining when database set up, and address class finalised.  
	 */
	@NamedQuery(name="CustomerOrder.findByAddressId", query="SELECT co FROM customer_order co WHERE co.address_Id = :addressId")
})
public class CustomerOrder {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	/* 
	 * @author Andrew Claybrook
	 * @author Tim Spencer
	 * Customer temporarily removed as will depend on how we construct SQL
	 * 
	 * @Id
	@JoinTable(name="customer",
		joinColumns=
			@JoinColumn(name="id", referencedColumnName="customer-id")
			)
	private Customer customer; */
		
	/**
	 *  Below variable used to signify status, be that basket, order or finished order
	 */
	
	@Column(name="status", nullable=false)
	@NotNull
	private Status status = Status.BASKET; 
	
	@OneToMany
	@JoinTable(name="customer_order_lines",
		joinColumns=
			@JoinColumn(name="customer_order_id", referencedColumnName="id")
	)
	private List<CustomerOrderLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	private Address deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	

	
	private Address billingAddress;
	
	private static int idCount = 0;
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Constructor without id. Automatically sets id as next idCount
	 * 
	 * @param iOrderLines List of Order Lines
	 * @param iDeliveryAddress Delivery Address (Address Object)
	 * @param iBillingAddress Billing Address (Address Object)
	 * @param Customer customer
	 * 
	 * @MethodAuthor Alex Dawson
	 * @version 0.4
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @version 0.5
	 * 
	 */
	public CustomerOrder(List<CustomerOrderLine> iOrderLines) {
		this.id = ++idCount;
		this.orderLines = iOrderLines;
	//	this.customer = customer;
	}
	
	/**
	 * Constructor with id.
	 * 
	 * @param iId Customer Order ID
	 * @param iOrderLines List of Order Lines
	 * @param iDeliveryAddress Delivery Address (Address Object)
	 * @param iBillingAddress Billing Address (Address Object)
	 * @param Customer customer
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public CustomerOrder(int iId, List<CustomerOrderLine> iOrderLines) {
		this.id = iId;
		//TODO Logic to check non-conflicting id?
		this.orderLines = iOrderLines;
	//	this.customer = customer;
	}

	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	/**
	 * Returns Customer Order ID
	 * 
	 * @return Customer Order ID
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets Customer Order ID
	 * 
	 * @param iId Customer Order ID to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setId(long iId) {
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

	/**
	 * 
	 * Get status
	 * 
	 * @return status
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */
	
	public Status getStatus() {
		return status;
	}

	/**
	 * Set status
	 * @param status
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */
	
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Set status
	 * @param status
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */
	
	
	/* public Customer getCustomer() {
		return customer;
	} */
	
	/**
	 * Set status
	 * @param status
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */

	/*
	public void setCustomer(Customer customer) {
		this.customer = customer;
	} */
	
	public double getCost() {
		double cost = 0;
		for(CustomerOrderLine cusOrderLine: orderLines) {
			cost += cusOrderLine.getProduct().getCurrentPrice(); 
		}
	
		return cost;		
	}

}
