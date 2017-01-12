package com.bae.ims.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bae.ims.entities.Address;
import com.bae.ims.managers.AddressManager;

@Stateless
public class AddressService {
	
	////////////////////////////////////////////////INJECTIONS/////////////////////////////////////////////////
	
	@Inject
	private AddressManager addressManager;
	
	///////////////////////////////////////////////METHODS/////////////////////////////////////////////////////

	
	public List<Address> getAllAddresses() {
		return addressManager.findAllAddresses();
	}
	
	
}
