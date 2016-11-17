package jar;

import java.util.ArrayList;

public interface StockManager {
	public Stock createStock (Stock stock);
	
	public void updateStock (Stock stock);
	
	public void removeStock (Stock stock);
	
	public Stock findStockById (Long id);
	
	public Stock findStockByStatus (String status);
	
	public ArrayList<Stock> findAllStock (); 
	
}
