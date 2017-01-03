package com.bae.ims.managers;

import java.util.ArrayList;

import com.bae.ims.entities.Stock;

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
