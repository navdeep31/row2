package com.bae.ims.managers;

import java.util.List;

import com.bae.ims.entities.Address;

//TODO Consider if Address managers are needed?

/**
 * Interface specification for Addresses
 * 
 * @author Josh Stanley
 * @author Alex Dawson
 * @version 0.2 06/12/2016
 */
public interface AddressManager {
	
	public void createAddress(Address address);
	
	public List<Address> findAllAddresses();
	
	public Address findAddressById();
}
