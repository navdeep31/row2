package jar;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="purchase_order")

@NamedQueries({
@NamedQuery(name="findById", query="SELECT p FROM purchase_order p WHERE p.id=:id"),
@NamedQuery(name="findByAddress", query="SELECT p FROM purchase_order p WHERE p.deliveryAddress=:deliveryAddress"),
@NamedQuery(name="findByEmployee", query="SELECT p FROM purchase_order p WHERE p.employee_id=:employee_id")

})
public class PurchaseOrder {
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinTable(name="purchase_order_line",
		joinColumns=@JoinColumn(name="purchase_order_id", referencedColumnName="id"))
	
	private List<PurchaseOrderLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	@NotNull
	private Employee employeeId;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@NotNull
	private Address deliveryAddress;
	
	@Column
	private LocalDate dateAdded;

	PurchaseOrder() {

	}

	public PurchaseOrder(int id, Employee employeeId, Address deliveryAddress, LocalDate dateAdded) {
		this.id = id;
		this.employeeId = employeeId;
		this.deliveryAddress = deliveryAddress;
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employeeId
	 */
	public Employee getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress
	 *            the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the orderLines
	 */
	public List<PurchaseOrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines the orderLines to set
	 */
	public void setOrderLines(List<PurchaseOrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	/**
	 * @return the dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	

}
