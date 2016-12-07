package com.bae.oc.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.bae.oc.enums.Status;

/**
 * Represents a Customer Order Line, with a single product and quantity
 * 
 * @author Alex Dawson
 * @version 0.4 22/11/2016
 * 
 * @author Tim Spencer
 * @author Andrew Claybrook
 * @version 0.5 06/12/2016
 *
 */
@Entity
@Table(name="customer_order_line")
@NamedQueries({
	
	/**
	 * @author Tim Spencer
	 * @author Andrew Claybrook
	 * Named queries set for review
	 */
	@NamedQuery(name="CustomerOrderLine.findAll", query="SELECT col FROM customer_order_line col"),
	@NamedQuery(name="CustomerOrderLine.findByCustomerOrder", query="SELECT col FROM customer_order_line co WHERE col.customer_order_id = :id")
})
public class CustomerOrderLine {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
	@Id
	@Column(name="customer_order_id", nullable=false)
	private long customerorderId; 
	
	@Id
	@Column(name="number", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lineNumber;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	@NotNull
	private Product product;
	
	@Column(name="quantity", nullable=false)
	@NotNull
	private int quantity;
	
	/**
	 * This adds a price once the order is confirmed. Will use a getter method in customerOrder entity to work it out. 
	 * @author Tim Spencer
	 * @author Andrew Claybrook
	 */
	
	@Column(name="item_Price")
	private double itemPrice;

	/*@Column(name="order_confirmation", nullable=false)
	@NotNull
	private boolean isConfirmed; */
	
	@OneToOne
	@JoinTable(name="customer_order",
		joinColumns=
			@JoinColumn(name="id", referencedColumnName="customer_order_id")
			)
	private Status status; 
	
	
	private static int lineNumberCount = 0;
	//TODO Possibly rename as id? Doesn't set line numbers from 1 per order currently
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Default constructor
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	
	/**
	 * Constructor without line number
	 * Automatically sets line number as next lineNumberCount
	 * 
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity (assumed positive)
	 * @param customerOrderId
	 * 
	 * @MethodAuthor Alex Dawson
	 * @version 0.4
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @version 0.5
	 */
	public CustomerOrderLine(long customerOrderId, Product iProduct, int iQuantity) {
		this.lineNumber = ++lineNumberCount;
		this.product = iProduct;
		this.quantity = iQuantity;
		this.customerorderId = customerOrderId;
		this.status = Status.BASKET;
		//TODO Check positive?
	}
	
	/**
	 * Constructor with line number
	 * 
	 * @param iLineNumber Line number
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity (assumed positive)
	 * @param customerOrderId
	 * 
	 * 
	 * @MethodAuthor Alex Dawson
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @version 0.5
	 */
	CustomerOrderLine(long customerOrderId, int iLineNumber, Product iProduct, int iQuantity, Status status)	{
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
		this.product = iProduct;
		this.quantity = iQuantity;
		this.customerorderId = customerOrderId;
		this.status = status; 
		//TODO Check non-negative?
	}
	
	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	/**
	 * Returns Line Number
	 * 
	 * @return Line Number
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Sets Line Number
	 * 
	 * @param iLineNumber Line Number
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setLineNumber(int iLineNumber) {
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
	}

	/**
	 * Returns Product (Object)
	 * 
	 * @return Product (Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets Product (Object)
	 * 
	 * @param iProduct Product (Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setProduct(Product iProduct) {
		this.product = iProduct;
	}

	/**
	 * Returns quantity of product on Order Line
	 * 
	 * @return Quantity of product on Order Line
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets quantity of product on Order Line
	 * 
	 * @param iQuantity Quantity of product on Order Line
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setQuantity(int iQuantity) {
		this.quantity = iQuantity;
		//TODO Check positive?
	}

	/**
	 *
	 * Gets a single item's price
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @return itemPrice
	 */
	
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 *
	 * Gets total price for line by multiplying item price vs. quantity
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @return itemPrice
	 * 
	 */
	
	public double getTotalLinePrice() {
		return itemPrice*quantity; 
	}
	
	/**
	 *
	 * Sets a single item's price - after orders are not baskets, this number cannot be changed. 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @param itemPrice
	 * 
	 */
	
	public void setItemPrice(double itemPrice) {
		if(status.equals(Status.BASKET)) this.itemPrice = itemPrice;
	}

	/**
	 * Don't know if required - may change status during runtime
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 *
	 * Get Customer Order Id
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 * @return customerOrderId
	 * 
	 */
	
	public long getCustomerorderId() {
		return customerorderId;
	}
	
	
}
