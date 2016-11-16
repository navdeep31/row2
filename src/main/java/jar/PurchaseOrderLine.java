package jar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Tim Spencer edit 0.2
 *
 */

/**
 * Creating shortcut for finding by purchase order
 */
@NamedQueries({
@NamedQuery(name = "FindByPurchaseOrder", query = "SELECT p FROM purchase_order_line, WHERE p.purchase_order_id=:purchase_order_id ORDER BY line_number DESC"),
@NamedQuery(name = "FindByStockID", query = "SELECT sid FROM purchase_order_line, WHERE sid.stock_id"),
@NamedQuery(name = "OrderByPurchaseOrderDESC", query = "SELECT a FROM purchase_order_line ORDER BY purchase_order_id DESC, line_number DESC"),
@NamedQuery(name = "OrderByPurchaseOrderASC", query = "SELECT a FROM purchase_order_line ORDER BY purchase_order_id ASC, line_number ASC")

})

@Entity
@Table(name = "purchase_order_line")
public class PurchaseOrderLine {

	/**
	 * Join Purchase order to purchase order line using join table command. Uses
	 * the id as it's own key.
	 */
	@Id
	@ManyToOne
	@JoinTable(name = "purchase_order", joinColumns = @JoinColumn(name = "purchase_order_id", referencedColumnName = "id", nullable = false))
	private long purchaseOrderId;

	/**
	 * Generates an ID for the line number.
	 */
	@Id
	@Column(name = "line_number", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lineNumber;

	@OneToOne
	@NotNull
	@JoinTable(name = "stock", joinColumns = @JoinColumn(name = "stock_id", referencedColumnName = "line_number", nullable = false))
	private int stockId;

	@Column(nullable = false)
	@NotNull
	private int quantity;

	public PurchaseOrderLine() {

	}

	public PurchaseOrderLine(int purchaseOrderId, int lineNumber, int stockId, int quantity) {
		this.purchaseOrderId = purchaseOrderId;
		this.lineNumber = lineNumber;
		this.stockId = stockId;
		this.quantity = quantity;
	}

	/**
	 * @return the purchaseOrderId
	 */
	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	/**
	 * @param purchaseOrderId
	 *            the purchaseOrderId to set
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
	 * @param lineNumber
	 *            the lineNumber to set
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
	 * @param stockId
	 *            the stockId to set
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
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
