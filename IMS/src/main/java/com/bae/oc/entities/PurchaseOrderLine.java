package com.bae.oc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



/**
 * Creating shortcut for finding by purchase order
 */
@NamedQueries({
@NamedQuery(name = "FindByPurchaseOrder", query = "SELECT p FROM purchase_order_line, WHERE p.purchase_order_id=:purchase_order_id ORDER BY line_number DESC"),
@NamedQuery(name = "FindByStockID", query = "SELECT sid FROM purchase_order_line, WHERE sid.stock_id"),
@NamedQuery(name = "OrderByPurchaseOrderDESC", query = "SELECT a FROM purchase_order_line ORDER BY purchase_order_id DESC, line_number DESC"),
@NamedQuery(name = "OrderByPurchaseOrderASC", query = "SELECT a FROM purchase_order_line ORDER BY purchase_order_id ASC, line_number ASC")

})

/**
 * 
 * @author Tim Spencer
 * @author Alex Dawson
 * @version 0.3 15/12/2016
 *
 */
@Entity
@Table(name = "purchase_order_line")
public class PurchaseOrderLine {
	
	/////////////////////////////////////////////////////ATTRIBUTES////////////////////////////////////////////////

	/**
	 * Generates an ID for the line number.
	 */
	@Id
	@Column(name = "line_number", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lineNumber;

	//TODO Review databasing
	
	//TODO Product databasing
	private Product product;

	@Column(nullable = false)
	@NotNull
	private int quantity;

	/////////////////////////////////////////////////////CONSTRUCTORS////////////////////////////////////////////////	
	
	/**
	 * All argument constructor
	 * 
	 * @param iLineNumber Line Number
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity of product to be ordered
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrderLine(int iLineNumber, Product iProduct, int iQuantity) {
		this.lineNumber = iLineNumber;
		this.product = iProduct;
		this.quantity = iQuantity;
	}
	
	/////////////////////////////////////////////////////METHODS////////////////////////////////////////////////	

	/**
	 * Returns the Purchase Order Line Number
	 * 
	 * @return Purchase Order Line Number
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}

	/**
	 * 
	 * 
	 * @param iLineNumberPurchase Order Line Number to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setLineNumber(int iLineNumber) {
		this.lineNumber = iLineNumber;
	}

	/**
	 * Returns the product of the order line
	 * 
	 * @return Product (Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Product getProduct() {
		return this.product;
	}
	
	/**
	 * Sets the product of the order line
	 * 
	 * @param iProduct Product (Object)
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setProduct(Product iProduct) {
		this.product = iProduct;
	}
	
	/**
	 * @return The quantity of product to order
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * @param iQuantity The quantity of product to order to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setQuantity(int iQuantity) {
		this.quantity = iQuantity;
	}

}
