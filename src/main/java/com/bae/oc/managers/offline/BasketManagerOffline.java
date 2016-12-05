package com.bae.oc.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.Product;
import com.bae.oc.managers.BasketManager;
import com.bae.oc.util.TestData;

/**
 * 
 * @author Tim Spencer
 *
 */

@Stateless
@Default
public class BasketManagerOffline implements BasketManager {

	@Inject
	private TestData testData;
	
	
	@Override
	public List<Product> findByCustomerId(long id) {
			for(Customer customer: testData.getCustomers()) {
				if(customer.getId()==id) {
					//return customer.getBasket();
					//Will need to be added once customer entity updated
				}
;			}
	
			return null;
	}

	@Override
	public void updateWishList(long customerId, List<Product> basket) {
		List<Customer> customers = testData.getCustomers();
		for(Customer customer : customers) {
			if(customer.getId() == customerId) {
				//customer.setBasket(basket);
				//Will need to be added once customer entity updated
			}   
		}
		
	}

}
