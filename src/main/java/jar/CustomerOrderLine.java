package jar;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Represents a Customer Order Line, with a single product and quantity
 * 
 * @author Alex Dawson
 * @version 0.3 16/11/2016
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
	 */
	CustomerOrderLine()
	{
		//TODO Keep this or not?
	}
	
	/**
	 * Constructor without line number
	 * Automatically sets line number as next lineNumberCount
	 * 
	 * @param iProduct Product (Object)
	 * @param iQuantity Quantity (assumed positive)
	 */
	CustomerOrderLine(Product iProduct, int iQuantity)
	{
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
	 */
	CustomerOrderLine(int iLineNumber, Product iProduct, int iQuantity)
	{
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
		this.product = iProduct;
		this.quantity = iQuantity;
		//TODO Check non-negative?
	}
	
	////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int iLineNumber) {
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product iProduct) {
		this.product = iProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int iQuantity) {
		this.quantity = iQuantity;
		//TODO Check positive?
	}
	
	

}
