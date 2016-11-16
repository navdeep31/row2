package jar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="purchase_order")

public class PurchaseOrder {
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	@NotNull
	private Employee employeeId;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@NotNull
	private Address deliveryAddress;

	PurchaseOrder() {

	}

	public PurchaseOrder(int id, Employee employeeId, Address deliveryAddress) {
		this.id = id;
		this.employeeId = employeeId;
		this.deliveryAddress = deliveryAddress;
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

}
