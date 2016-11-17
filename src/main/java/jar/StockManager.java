package jar;

import java.util.ArrayList;

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
	
	public Stock createStock (Stock stock);
	
	public void updateStock (Stock stock);
	
	public void removeStock (Stock stock);
	
	public Stock findStockById (Long id);
	
	public Stock findStockByStatus (String status);
	
	public ArrayList<Stock> findAllStock (); 
	
}
