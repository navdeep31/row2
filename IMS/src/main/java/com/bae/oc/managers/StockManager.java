package com.bae.oc.managers;

import java.util.ArrayList;

import com.bae.oc.entities.Stock;

/**
 * 
 * @author Tim Spencer
 *
 */

public interface StockManager {
	
	/**
	 * 
	 * Method Stubs
	 * 
	 */
	
	public void createStock (Stock stock);
	
	public void updateStock (Stock stock);
	
	public void removeStock (Stock stock);
	
	public ArrayList<Stock> findStockById (Long id);
	
	public ArrayList<Stock> findStockByStatus (String status);
	
	public ArrayList<Stock> findAllStock (); 
	
}
