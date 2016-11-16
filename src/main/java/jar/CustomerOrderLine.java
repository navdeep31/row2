package jar;

/**
 * Represents a Customer Order Line, with a single product and quantity
 * 
 * @author Alex Dawson
 * @version 0.2 16/11/2016
 *
 */
public class CustomerOrderLine {
	
	/////////////////////////////////////////////FIELDS//////////////////////////////////////////////////
	
	private int lineNumber;
	private Product product;
	private int quantity;
	
	private static int lineNumberCount = 0;
	//TODO Possibly rename as id? Doesn't set line numbers from 1 per order currently
	
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
