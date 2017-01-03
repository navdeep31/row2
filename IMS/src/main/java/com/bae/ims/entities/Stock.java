package com.bae.ims.entities;

import javax.persistence.*;

import com.bae.ims.enums.ProductStatus;

@Entity
@Table(name="stock")
public class Stock {
	//Variables
	@Id
	@Column(name="id", nullable =false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private ProductStatus status; 
	
	
	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	//Stock constructor
	public Stock(long id, ProductStatus status) {
		this.id = id;
		this.status = status;
	}

	public void setId(long id) {
		this.id = id;
	}

	//Getters and setters
	public long getId() {
		return id;
	}


	
}
