package jar;
//@Entity
//@Table(name="product")
import java.time.LocalDate;

public class Product {
	private long productID;
	private String name;
	private String description;
	private int quantity;
	private double rrp;
	private double currentPrice;
	private String status;
	private LocalDate dateAdded;
	
	
	
	public Product(long productID, String name, String description, int quantity, double rrp, double currentPrice,
			String status, LocalDate dateAdded) {
		
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.rrp = rrp;
		this.currentPrice = currentPrice;
		this.status = status;
		this.dateAdded = dateAdded;
	}



	public long getProductID() {
		return productID;
	}



	public void setProductID(long productID) {
		this.productID = productID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getRrp() {
		return rrp;
	}



	public void setRrp(double rrp) {
		this.rrp = rrp;
	}



	public double getCurrentPrice() {
		return currentPrice;
	}



	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public LocalDate getDateAdded() {
		return dateAdded;
	}



	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	

}
