/**
 * 
 */
package com.bae.oc.entities;

/**
 * @author Josh Stanley
 *
 */
public class Address {
	
	//////////////////////////////////////////////// Attributes/////////////////////////////////////////////////////
	
	private int id;
	private String line1;
	private String line2;
	private String postcode;
	private String city;
	private static int idCount = 0;
	//TODO Refactor for database ID

	/////////////////////////////////////////// Constructor////////////////////////////////////////////////////////

	/**
	 * Constructor without ID
	 * 
	 * Automatically sets next ID
	 * 
	 * @param iLine1 Address Line 1
	 * @param iLine2 Address Line 2
	 * @param iPostcode Postcode
	 * @param iCity City
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address(String iLine1, String iLine2, String iPostcode, String iCity) {
		this(++idCount, iLine1, iLine2, iPostcode, iCity);
	}
	
	/**
	 * Constructor without ID & Line 2
	 * 
	 * Automatically sets next ID
	 * 
	 * @param iLine1 Address Line 1
	 * @param iLine2 Address Line 2
	 * @param iPostcode Postcode
	 * @param iCity City
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address(String iLine1, String iPostcode, String iCity) {
		this(++idCount, iLine1, iPostcode, iCity);
	}
	
	/**
	 * Constructor without Line 2
	 * 
	 * @param iId
	 * @param iLine1 Address Line 1
	 * @param iPostcode Postcode
	 * @param iCity City
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address(int iId, String iLine1, String iPostcode, String iCity) {
		this.id = iId;
		this.line1 = iLine1;
		this.postcode = iPostcode;
		this.city = iCity;
	}
	
	/**
	 * Constructor for new address which will be added to customer data
	 * 
	 * 
	 * @param iId - Address ID
	 * @param iLine1 - Address Line 1
	 * @param iLine2 - Address Line 2
	 * @param iPostcode -  Address Postcode
	 * @param iCity - Address City
	 * 
	 * @MethodAuthor Josh Stanley
	 */

	public Address(int iId, String iLine1, String iLine2, String iPostcode, String iCity) {
		this.id = iId;
		this.line1 = iLine1;
		this.line2 = iLine2;
		this.postcode = iPostcode;
		this.city = iCity;

	}

	////////////////////////////////////////////// Default//////////////////////////////////////////////////
	/////////////////////////////////////////// Constructor/////////////////////////////////////////////////
	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */
	public Address() {

	}

	/////////////////////////////////////////// Getters/////////////////////////////////////////////////
	/////////////////////////////////////////// Setters/////////////////////////////////////////////////
	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public int getId() {
		return id;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public String getLine1() {
		return line1;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public String getLine2() {
		return line2;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public String getPostcode() {
		return postcode;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @Method Author Josh Stanley
	 * 
	 */

	public void setCity(String city) {
		this.city = city;
	}

}