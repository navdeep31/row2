package com.bae.ims.controllers.session;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bae.ims.entities.Address;

/**
 * Stores Selected Address (selected address on current order page to append to order once submitted)
 * 
 * @author Andrew Claybrook
 * @version 0.1 12/01/2017
 *
 */
@Named("selectedAddress")
@SessionScoped
public class SelectedAddress implements Serializable {
	

	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6345490354634709775L;
	
	///////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////////
	
	private Address address = null;
	private List<Address> addresses;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////
	
	/**
	 * Returns Selected (Purchase) Order
	 * 
	 * @return Selected (Purchase) Order
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public Address getAddress() {
		return this.address;
	}
	
	/**
	 * Sets Selected (Purchase) Order
	 * 
	 * @param iOrder Selected (Purchase) Order to set
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setAddress(Address iAddressOrder) {
		this.address = iAddressOrder;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
}
