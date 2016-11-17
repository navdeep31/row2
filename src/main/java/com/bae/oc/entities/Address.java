/**
 * 
 */
package com.bae.oc.entities;

/**
 * @author Administrator
 *
 */
public class Address {
	//////////////////////////////////////////////// Attributes/////////////////////////////////////////////////////
	private int id;
	private int houseNumber;
	private String line1;
	private String line2;
	private String postcode;
	private String city;

	/////////////////////////////////////////// Constructor////////////////////////////////////////////////////////
	public Address(int id, int houseNumber, String line1, String line2, String postcode, String city) {
		this.id = id;
		this.houseNumber = houseNumber;
		this.line1 = line1;
		this.line2 = line2;
		this.postcode = postcode;
		this.city = city;

	}

	////////////////////////////////////////////// Default//////////////////////////////////////////////////
	/////////////////////////////////////////// Constructor/////////////////////////////////////////////////
	public Address() {

	}

	/////////////////////////////////////////// Getters/////////////////////////////////////////////////
	/////////////////////////////////////////// Setters/////////////////////////////////////////////////

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}