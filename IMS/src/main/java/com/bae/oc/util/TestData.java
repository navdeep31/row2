package com.bae.oc.util;

import java.util.ArrayList;
import java.util.List;

import com.bae.oc.entities.Stock;
import com.bae.oc.enums.ProductStatus;

public class TestData {	{

	List<Stock> stock = new ArrayList<>();
	
	
	stock.add(new Stock(1l, ProductStatus.AVALIABLE));
		stock.add(new Stock(2l, ProductStatus.AVALIABLE));
		stock.add(new Stock(3l, ProductStatus.AVALIABLE));
		stock.add(new Stock(4l, ProductStatus.AVALIABLE));
		stock.add(new Stock(5l, ProductStatus.AVALIABLE));
		stock.add(new Stock(6l, ProductStatus.DISCONTINUED));
		stock.add(new Stock(7l, ProductStatus.AVALIABLE));
		stock.add(new Stock(8l, ProductStatus.ON_HOLD));
		stock.add(new Stock(9l, ProductStatus.AVALIABLE));
		stock.add(new Stock(10l, ProductStatus.AVALIABLE));
		stock.add(new Stock(11l, ProductStatus.ON_HOLD));
		stock.add(new Stock(12l, ProductStatus.AVALIABLE));
		stock.add(new Stock(13l, ProductStatus.AVALIABLE));
}
}