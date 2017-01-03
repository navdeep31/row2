package com.bae.oc.managers.offline;

import javax.ejb.Stateless; 
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bae.oc.entities.Stock;
import com.bae.oc.managers.StockManager;
import com.bae.oc.util.TestData;

import java.util.ArrayList;
import java.util.List;

@Stateless
@Default
public class StockManagerOffline implements StockManager {

	@Inject
	private TestData testData; 
	
	@Override
	public void createStock(Stock stock) {
		List<Stock> stocks = testData.getStock();
		stock.setId(stocks.size()+1);
		stocks.add(stock);
		testData.setStock(stocks);
		
	}

	@Override
	public void updateStock(Stock stock) {
		for(Stock testStock: testData.getStock()) {
			if(testStock.getId()==stock.getId()) {
				testStock=stock; 
			}
		}
		
	}

	@Override
	public void removeStock(Stock stock) {
		long iterator = 0;
		for(Stock testStock : testData.getStock()) {
			if(testStock.equals(stock)) {
				testData.getStock().remove(iterator); 
			}
			iterator++; 
		}
		
	}

	@Override
	public ArrayList<Stock> findStockById(Long id) {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for(Stock testStock: testData.getStock()) {
			if(id==testStock.getId()) {
				stocks.add(testStock);
			}
		}
		return stocks;
	}

	@Override
	public ArrayList<Stock> findStockByStatus(String status) {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for(Stock testStock: testData.getStock()) {
			if(status.equals(testStock.getStatus())) {
				stocks.add(testStock);
			}
		}
		return stocks;
	}

	@Override
	public ArrayList<Stock> findAllStock() {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for(Stock testStock: testData.getStock()) {
				stocks.add(testStock);
			
		}
		return stocks;
	}

}
