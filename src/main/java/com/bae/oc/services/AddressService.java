package com.bae.oc.services;

import javax.ejb.Stateless;

/**
 * Deals with business logic for validating addresses
 * 
 * @author Alex Dawson
 *
 */
@Stateless
public class AddressService {
	
	/**
	 * Checks if given address is valid
	 * 
	 * @param iLine1
	 * @param iLine2
	 * @param iPostcode
	 * @param iCity
	 * @return
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public boolean isValidAddress(String iLine1, String iLine2, String iPostcode, String iCity) {
		
		// invalid if no line1 or postcode
		if(iLine1.isEmpty() || iPostcode.isEmpty()) {
			return false;
		}
		
		//TODO Validation for correct postcode format
		
		//TODO Validation for matching line1 and postcode
		
		return true;
	}

}
