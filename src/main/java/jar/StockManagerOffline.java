package jar;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject; 
import java.util.ArrayList;

@Stateless
@Default
public class StockManagerOffline implements StockManager {

	@Inject
	private TestData testData; 
	
	@Override
	public Stock createStock(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stock findStockById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock findStockByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Stock> findAllStock() {
		// TODO Auto-generated method stub
		return null;
	}

}
