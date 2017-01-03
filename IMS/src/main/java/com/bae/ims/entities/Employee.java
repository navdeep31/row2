package com.bae.ims.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

/**
 * 
 * @author Tim Spencer v0.2
 *
 */


public class Employee {
	//Variables
	@Id
	@Column(name="id", nullable =false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=45)
	@Size(max=45)
	@NotNull
	private String password_hash;
	
	@Column(nullable=false)
	private String email; 
	
	@Column(nullable=false)
	private String name; 
	
	//Employee constructor
	/**
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param password_hash
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 */
	public Employee (long id, String name, String email, String password_hash) {
		this.id=id;
		this.name = name;
		this.email=email;
		this.password_hash=password_hash; 
	}
	
	/**
	 * 
	 * @param name
	 * @param email
	 * @param password_hash
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 */
	public Employee (String name, String email, String password_hash) {
		id++; 
		this.name = name;
		this.email=email;
		this.password_hash=password_hash; 
	}

	//Getters and setters  
	public long getId() {
		return id;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

	
	
}
