package jar;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject; 
import java.util.ArrayList;
import java.util.List;

@Stateless
@Default
public class StockManagerOffline implements StockManager {

	@Inject
	private TestData testData; 
	
	@Override
	public void createStock(Stock stock) {
		List<Stock> stocks = testData.getStocks();
		stock.setId(stocks.size()+1);
		stocks.add(stock);
		testData.setStocks(stocks);
		
	}

	@Override
	public void updateStock(Stock stock) {
		for(Stock testStock: testData.getStocks()) {
			if(testStock.getId()==stock.getId()) {
				testStock=stock; 
			}
		}
		
	}

	@Override
	public void removeStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Stock> findStockById(Long id) {
		ArrayList<Stock> stocks = new ArrayList();
		for(Stock testStock: testData.getStocks()) {
			if(id==testStock.getId()) {
				stocks.add(testStock);
			}
		}
		return stocks;
	}

	@Override
	public ArrayList<Stock> findStockByStatus(String status) {
		ArrayList<Stock> stocks = new ArrayList();
		for(Stock testStock: testData.getStocks()) {
			if(status.equals(testStock.getStatus())) {
				stocks.add(testStock);
			}
		}
		return stocks;
	}

	@Override
	public ArrayList<Stock> findAllStock() {
		ArrayList<Stock> stocks = new ArrayList();
		for(Stock testStock: testData.getStocks()) {
				stocks.add(testStock);
			
		}
		return stocks;
	}

}
