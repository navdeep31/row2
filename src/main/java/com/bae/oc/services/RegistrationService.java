package com.bae.oc.services;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.oc.entities.Address;
import com.bae.oc.entities.Customer;
import com.bae.oc.managers.CustomerManager;

/**
 * 
 * @author Josh Stanley
 * 
 * @version 0.1 06/12/2016
 *
 */

@Stateless
public class RegistrationService {

	@Inject
	public CustomerManager customerManager;
/**
 * Customer registration
 * Takes in the full Address details 
 * 
 * @param iFirstName - First Name
 * @param iLastName -  Last Name
 * @param iEmail -     Email
 * @param iPassword -  Password
 * @param iLine1 -     Line 1
 * @param iLine2 -     Line 2
 * @param iPostcode -  Postcode
 * @param iCity -      City
 * @return customer -  Customer Object
 * 
 * @MethodAuthor Josh Stanley
 */
	public Customer register(String iFirstName, String iLastName, String iEmail, String iPassword, String iLine1,
			String iLine2, String iPostcode, String iCity) {

		Customer customer = customerManager.createNewCustomer(new Customer(iFirstName, iLastName, iEmail, iPassword,
				new Address(iLine1, iLine2, iPostcode, iCity), getCurrentDate()));

		return customer;
	}
	//TODO add exceptions
	
/**
 * Customer registration
 * Only needs to take in line 1, postcode and city for the Address details
 * Returns a customer 
 * 
 * @param iFirstName -  First Name
 * @param iLastName -   Last Name
 * @param iEmail -      Email
 * @param iPassword -   Password
 * @param iLine1 -      Line 1
 * @param iPostcode -   Postcode
 * @param iCity -       City
 * @return customer -   Customer Object
 * 
 * @MethodAuthor Josh Stanley
 */
	
	public Customer register(String iFirstName, String iLastName, String iEmail, String iPassword, String iLine1,
			String iPostcode, String iCity) {

		Customer customer = customerManager.createNewCustomer(new Customer(iFirstName, iLastName, iEmail, iPassword,
				new Address(iLine1, iPostcode, iCity), getCurrentDate()));

		return customer;
	}
	//TODO add exceptions

/**
 * Sets the DateAdded attribute for the customer
 *  
 * @return LocalDate
 * 
 * @MethodAuthor Josh Stanley
 */
	
	private LocalDate getCurrentDate() {
		return LocalDate.now(ZoneId.of("Europe/London"));
	}
}
