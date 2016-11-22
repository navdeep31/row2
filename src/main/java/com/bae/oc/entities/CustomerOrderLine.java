package com.bae.oc.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Represents a Customer Order Line, with a single product and quantity
 * 
 * @author Alex Dawson
 * @version 0.4 22/11/2016
 *
 */
@Entity
@Table(name="customer_order_line")
@NamedQueries({
	@NamedQuery(name="CustomerOrderLine.findAll", query="SELECT col FROM customer_order_line col"),
	@NamedQuery(name="CustomerOrderLine.findByCustomerOrder", query="SELECT col FROM customer_order_line co WHERE col.customer_order_id = :id")
})
public class CustomerOrderLine {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
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
	
	private static int lineNumberCount = 0;
	//TODO Possibly rename as id? Doesn't set line numbers from 1 per order currently
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	
	/////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////
	
	/**
	 * Default constructor
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	CustomerOrderLine() {
		//TODO Keep this or not?
	}
	
	/**
	 * Constructor without line number
	 * Automatically sets line number as next lineNumberCount
	 * 
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity (assumed positive)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	CustomerOrderLine(Product iProduct, int iQuantity) {
		this.lineNumber = ++lineNumberCount;
		this.product = iProduct;
		this.quantity = iQuantity;
		//TODO Check positive?
	}
	
	/**
	 * Constructor with line number
	 * 
	 * @param iLineNumber Line number
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity (assumed positive)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	CustomerOrderLine(int iLineNumber, Product iProduct, int iQuantity)	{
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
		this.product = iProduct;
		this.quantity = iQuantity;
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
	
	

}
