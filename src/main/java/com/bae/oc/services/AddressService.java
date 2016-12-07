package com.bae.oc.services;

import javax.ejb.Stateless;

import com.bae.oc.entities.Address;

/**
 * Deals with business logic for validating addresses
 * 
 * @author Alex Dawson
 *
 */
@Stateless
public class AddressService {
	
	/**
	 * Overloading for no-line-2 attribute parameter input
	 * 
	 * @param iLine1 Line 1 of Address
	 * @param iPostcode Postcode
	 * @param iCity City
	 * @return boolean of whether address is valid
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public boolean isValidAddress(String iLine1, String iPostcode, String iCity) {
		
		return isValidAddress(new Address(iLine1, iPostcode, iCity));
	}
	
	/**
	 * Overloading for full attribute parameter input
	 * 
	 * @param iLine1 Line 1 of Address
	 * @param iLine2 Line 2 of Address
	 * @param iPostcode Postcode
	 * @param iCity City
	 * @return boolean of whether address is valid
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public boolean isValidAddress(String iLine1, String iLine2, String iPostcode, String iCity) {
		
		return isValidAddress(new Address(iLine1, iLine2, iPostcode, iCity));
	}
	
	/**
	 * Checks if given address is valid
	 * 
	 * @param iAddress Address (Object)
	 * @return boolean of whether address is valid
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public boolean isValidAddress(Address iAddress) {
		
		// invalid if no line1 or postcode
		if(iAddress.getLine1().isEmpty() || iAddress.getPostcode().isEmpty()) {
			return false;
		}
		
		//TODO Validation for correct postcode format
		
		//TODO Validation for matching line1 and postcode
		
		return true;
	}

}
