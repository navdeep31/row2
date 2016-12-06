package com.bae.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Address;
import com.bae.oc.entities.Customer;
import com.bae.oc.managers.CustomerManager;

/**
 * Deals with business logic for dealing with Customer entities
 * 
 * In particular editing customer details
 * 
 * @author Alex Dawson
 *
 */
@Stateless
public class CustomerService {
	
	@Inject
	private CustomerManager customerManager;
	
	/**
	 * Updates Customer when attributes are edited
	 * 
	 * Assumes non-edited fields are passed in as null
	 * 
	 * @param iCustomer Customer to be updated
	 * @param iFirstName Updated First Name
	 * @param iLastName Updated Last Name
	 * @param iEmail Updated Email
	 * @param iPassword Updated Password
	 * @param iLine1 Updated Line1 of Address
	 * @param iLine2 Updated Line2 of Address
	 * @param iPostcode Updated Postcode of Address
	 * @param iCity Updated City of Address
	 * @return Updated Customer
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	//TODO Check if appropriate to set return type as Customer?
	public Customer updateCustomer(Customer iCustomer, String iFirstName, String iLastName, String iEmail, String iPassword, String iLine1, String iLine2, String iPostcode, String iCity) {
		if(iFirstName != null) iCustomer.setFirstName(iFirstName);
		if(iLastName != null) iCustomer.setFirstName(iLastName);
		if(iEmail != null) iCustomer.setFirstName(iEmail);
		if(iPassword != null) iCustomer.setFirstName(iPassword);
		//TODO Consider raising exception for incorrect combination of Address updates?
		if(iLine1 != null && iPostcode != null &&iCity != null) {
			if(iLine2 != null) {
				iCustomer.setAddress(new Address(iLine1, iLine2, iPostcode, iCity) );
			} else {
				iCustomer.setAddress(new Address(iLine1, iPostcode, iCity) );
			}
		}
		customerManager.updateCustomer(iCustomer);
		return iCustomer;
	}
}
