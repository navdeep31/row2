package com.bae.oc.entities;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {
	//Variables
	@Id
	@Column(name="id", nullable =false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String status; 
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//Stock constructor
	public Stock(int id) {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	//Getters and setters
	public int getId() {
		return id;
	}


	
}
