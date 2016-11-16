package jar;

public class PurchaseOrder {
	
	private int id;
	private int employeeId;
	private String deliveryAddress;
	
	PurchaseOrder() 
	{
		
	}

	public PurchaseOrder(int id, int employeeId, String deliveryAddress) {
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	
	

}
