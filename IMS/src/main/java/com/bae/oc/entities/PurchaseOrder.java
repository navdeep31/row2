package com.bae.oc.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="purchase_order")

/**
 * 
 * 
 * @author Somebody?
 * @author Alex Dawson
 * 
 * @version 0.2 15/12/2016
 *
 */
@NamedQueries({
@NamedQuery(name="findById", query="SELECT p FROM purchase_order p WHERE p.id=:id"),
@NamedQuery(name="findByAddress", query="SELECT p FROM purchase_order p WHERE p.deliveryAddress=:deliveryAddress"),
@NamedQuery(name="findByEmployee", query="SELECT p FROM purchase_order p WHERE p.employee_id=:employee_id")

})
public class PurchaseOrder {
	
	/////////////////////////////////////////////////////ATTRIBUTES////////////////////////////////////////////////
	
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
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@NotNull
	private Address deliveryAddress;
	
	//TODO Persisting address
	
	@Column
	private LocalDate dateAdded;
	
	private static int idCount = 0;
	//TODO Possibly needs a rethink with database integration? (unless stored in database?)
	
	/////////////////////////////////////////////////////CONSTRUCTORS////////////////////////////////////////////////

	//TODO Review required constructors
	
	/**
	 * Default constructor
	 */
	PurchaseOrder() {
		this.id = idCount++;
		this.orderLines = new ArrayList<PurchaseOrderLine>();
	}

	/**
	 * 
	 * 
	 * @param id
	 * @param employee
	 * @param deliveryAddress
	 * @param dateAdded
	 * 
	 * @MethodAuthor Somebody
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrder(int id, Employee employee, Address deliveryAddress, LocalDate dateAdded) {
		this(id, new ArrayList<PurchaseOrderLine>(), employee, deliveryAddress, dateAdded);
	}
	
	/**
	 * All arguments constructor
	 * 
	 * @param iId Purchase Order ID
	 * @param iOrderLines Order Lines
	 * @param iEmployee Employee (that placed order)
	 * @param iDeliveryAddress Delivery Address
	 * @param iDateAdded Date Added
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public PurchaseOrder(int iId, List<PurchaseOrderLine> iOrderLines, Employee iEmployee, Address iDeliveryAddress, LocalDate iDateAdded) {
		this.id = iId;
		this.orderLines = iOrderLines;
		this.employee = iEmployee;
		this.deliveryAddress = iDeliveryAddress;
		this.dateAdded = iDateAdded;
	}
	
	/////////////////////////////////////////////////////METHODS////////////////////////////////////////////////

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
	 * @return Employee
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Employee getEmployee() {
		return this.employee;
	}

	/**
	 * @param iEmployee Employee to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setEmployeeId(Employee iEmployee) {
		this.employee = iEmployee;
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
