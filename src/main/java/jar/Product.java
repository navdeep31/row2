
package jar;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name="product")
@NamedQuery(name="findByID", query="SELECT p FROM product WHERE p.id=:id")
//@NamedQuery(name="findByName", query="SELECT p FROM product WHERE p.name=:name")
public class Product {
	


	@Id
	@Column(name = "id", nullable=false, unique = true)
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long productID;
	
	@ManyToOne
	@JoinColumn(name="stock_id", nullable =false)
	@NotNull
	private long stockID;
	
	@Column(length=225)
	@Size(max=225)
	@NotNull
	private String name;
	
	@Column(length=225)
	@Size(max=225)
	@NotNull
	private String description;
	
	@Column
	@NotNull
	private int quantity;
	
	@Column
	@NotNull
	private int rrp;
	
	@Column(name="current_price")
	@NotNull
	private int currentPrice;
	
	@Column(length=225)
	@Size(max=225)
	@NotNull
	private String status;
	
	@Column(name="date_added")
	@NotNull
	private LocalDate dateAdded;
	
	
	//Constructors
	public Product(long productID, long stockID, String name, String description, int quantity, int rrp,
			int currentPrice, String status, LocalDate dateAdded) {
		super();
		this.productID = productID;
		this.stockID = stockID;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.rrp = rrp;
		this.currentPrice = currentPrice;
		this.status = status;
		this.dateAdded = dateAdded;
	}



	//Getters and Setters
	public long getProductID() {
		return productID;
	}



	public void setProductID(long productID) {
		this.productID = productID;
	}

	public long getStockID() {
		return stockID;
	}



	public void setStockID(long stockID) {
		this.stockID = stockID;
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



	public void setRrp(int rrp) {
		this.rrp = rrp;
	}



	public double getCurrentPrice() {
		return currentPrice;
	}



	public void setCurrentPrice(int currentPrice) {
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
