package jar;

public class CustomerOrderLine {
	
	private int lineNumber;
	private Product product;
	private int quantity;
	
	CustomerOrderLine()
	{
		//TODO Constructors
	}
	
	CustomerOrderLine(Product iProduct, int iQuantity)
	{
		this.product = iProduct;
		this.quantity = iQuantity;
		//TODO Check positive?
	}
	
	CustomerOrderLine(int iLineNumber, Product iProduct, int iQuantity)
	{
		this.lineNumber = iLineNumber;
		//TODO Check non-conflicting?
		this.product = iProduct;
		this.quantity = iQuantity;
		//TODO Check non-negative?
	}

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
		// Check positive?
	}
	
	

}
