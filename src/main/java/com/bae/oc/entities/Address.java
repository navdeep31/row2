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

	/////////////////////////////////////////// Constructor////////////////////////////////////////////////////////

	/**
	 * 
	 * @param id Address ID
	 * @param line1
	 * @param line2
	 * @param postcode
	 * @param city
	 * 
	 * @MethodAuthor Josh Stanley
	 */

	public Address(int id, String line1, String line2, String postcode, String city) {
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.postcode = postcode;
		this.city = city;

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