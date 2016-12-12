package com.bae.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Address;
import com.bae.oc.managers.AddressManager;

/**
 * Deals with business logic for validating addresses
 * 
 * @author Alex Dawson
 *
 */
@Stateless
public class AddressService {
	
	@Inject
	AddressManager addressManager; 
	
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
	
	/**
	 * Checks if an address entered already exists on system
	 * 
	 * Populates a List of all addresses stored in the Address Manager.
	 * This is iterated through to find a match that equals that address, if so then the original address is returned
	 * If no address is found then the address passed is new so this is returned.	 * 
	 * 
	 * @param iAddress Address 
	 * @return Address 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Andrew Claybrook
	 */
	public Address checkAddressExists(Address iAddress) {
		List<Address> addresses = addressManager.findAllAddresses();
			
		for(Address address : addresses){
			if(iAddress.getLine1().equals(address.getLine1()) && iAddress.getPostcode().equals(address.getPostcode()) 
					&& iAddress.getCity().equals(address.getCity())){
				return address;
			}
		}
		
		return iAddress;
		
		
	}

}
