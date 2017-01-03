/**
 * Represents NB's products and their attributes for the online catalogue
 * @author N GILL
 * @version 0.2 05/12/2016
 */

package com.bae.ims.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bae.ims.enums.ProductStatus;

import java.time.LocalDate;

@Entity
@Table(name="product")
@NamedQueries({
@NamedQuery(name="findByID", query="SELECT p FROM product WHERE p.id=id"),
@NamedQuery(name="findByname", query="SELECT * FROM product WHERE p.name=:name"),
@NamedQuery(name="OrderByDateAdded", query="SELECT * FROM product ORDER BY date_added DESC")

})

public class Product {
	
	/////////////////////FIELDS/////////////////////////
	
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
	//Assume Product in pence hence integer
	private long rrp;
	
	
	@Column(name="current_price")
	@NotNull
	//Assume Product in pence hence integer
	private long currentPrice;
	
	@Column(length=225)
	@Size(max=225)
	@NotNull
	private ProductStatus status;
	
	@Column(name="date_added")
	@NotNull
	private LocalDate dateAdded;
	
	@Column(name="category")
	@NotNull
	private String category;
	
	
	/////////////////////CONSTRUCTOR/////////////////////////
	
	/**
	 * Constructor
	 * 
	 * @MethodAuthor N GILL
	 * @MethodAuthor Andrew Claybrook
	 */
	public Product(){}
	
	public Product(long productID, long stockID, String name, String description, int quantity, long rrp,
			long currentPrice, ProductStatus status, LocalDate dateAdded, String category) {
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
		this.category = category;
	}



	/////////////////////Getters and Setters/////////////////////////
	/**
	 * Returns Product ID
	 * 
	 * @return Product ID
	 * 
	 * @MethodAuthor N GILL
	 */
	public long getProductID() {
		return productID;
	}



	public void setProductID(long productID) {
		this.productID = productID;
	}

	
	/**
	 * Returns Stock ID
	 * 
	 * @return Stock ID
	 * 
	 * @MethodAuthor N GILL
	 */
	public long getStockID() {
		return stockID;
	}



	public void setStockID(long stockID) {
		this.stockID = stockID;
	}

	
	/**
	 * Returns Product Name
	 * 
	 * @return Product Name
	 * 
	 * @MethodAuthor N GILL
	 */
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Returns Product Description
	 * 
	 * @return Product Description
	 * 
	 * @MethodAuthor N GILL
	 */
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Returns Product Quantity
	 * 
	 * @return Product Quantity
	 * 
	 * @MethodAuthor N GILL
	 */
	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * Returns Product Recommended Retail Price
	 * 
	 * @return Product Recommended Retail Price
	 * 
	 * @MethodAuthor N GILL
	 */
	public long getRrp() {
		return rrp;
	}



	public void setRrp(long rrp) {
		this.rrp = rrp;
	}


	/**
	 * Returns Product Current Price
	 * 
	 * @return Product Current Price
	 * 
	 * @MethodAuthor N GILL
	 */
	public long getCurrentPrice() {
		return currentPrice;
	}



	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}


	/**
	 * Returns Product Status
	 * 
	 * @return Product Status
	 * 
	 * @MethodAuthor N GILL
	 */
	public ProductStatus getStatus() {
		return status;
	}



	public void setStatus(ProductStatus status) {
		this.status = status;
	}


	/**
	 * Returns Product Date Added
	 * 
	 * @return Product Date Added
	 * 
	 * @MethodAuthor N GILL
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}



	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	/**
	 * Returns Product Category
	 * 
	 * @return Product Category
	 * 
	 * @MethodAuthor N GILL
	 */
	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}
	
	
	

}
