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

public class AddressManagerOffline implements AddressManager {
	@Inject
	private TestData testData;
	
	
	@Override
	public void createAddress(Address address) {
		
		List<Address> addresses = testData.getAddress();
		address.setId(addresses.size()+1);
		addresses.add(address);
		testData.setAddress(addresses);
	}

}
