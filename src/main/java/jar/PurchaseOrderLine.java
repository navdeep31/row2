package jar;

public class PurchaseOrderLine {
	
	private int purchaseOrderId;
	private int lineNumber;
	private int stockId;
	private int quantity;
	
	public PurchaseOrderLine()
	{
		
	}
	
	public PurchaseOrderLine(int purchaseOrderId, int lineNumber, int stockId, int quantity) 
	{
		this.purchaseOrderId = purchaseOrderId;
		this.lineNumber = lineNumber;
		this.stockId = stockId;
		this.quantity = quantity;
	}

	/**
	 * @return the purchaseOrderId
	 */
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	/**
	 * @param purchaseOrderId the purchaseOrderId to set
	 */
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
