package com.bae.oc.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Address;
import com.bae.oc.managers.AddressManager;
import com.bae.oc.util.TestData;
@Stateless
@Default

/**
 * Implements an Address Manager with Test Data (without a database)
 * 
 * @author Josh Stanley
 * @author Alex Dawson
 *
 */
public class AddressManagerOffline implements AddressManager {
	@Inject
	private TestData testData;
	
	/**
	 * Creates a new address, adding it to test data
	 * 
	 *@MethodAuthor Josh Stanley
	 *@MethodAuthor Alex Dawson
	 */
	@Override
	public void createAddress(Address address) {
		
		List<Address> addresses = testData.getAddresses();
		address.setId(addresses.size()+1);
		//TODO Consider ID issues
		addresses.add(address);
		testData.setAddresses(addresses);
	}

	@Override
	public List<Address> findAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findAddressById() {
		// TODO Auto-generated method stub
		return null;
	}

}
