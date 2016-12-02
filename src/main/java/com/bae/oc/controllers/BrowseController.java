package com.bae.oc.controllers;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("browse")
@ConversationScoped
public class BrowseController implements Serializable {
	@Inject
	// private ProductService productService;
	private PaginationHelper paginationHelper;
	private DataModel<ProductItem> products = null;

	private void recreateModel() {
		products = null;

	}

	public DataModel<ProductItem> getProducts() {
		return (DataModel<ProductItem>) getPagination().createPageDataModel();
	}

	public PaginationHelper getPagination(){
		if (paginationHelper == null){ 
			paginationHelper = new PaginationHelper(9){
				@Override public int getItemsCount(){
					return productService.findAllActive().size()
				}
				@Override public DataModel<ProductItem> createPageDataModel(){
					try{
						return new ListDataModel<ProductItem>(productService.findAllActive().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					}catch (Exception e){
						return new ListDataModel<ProductItem(productService.findAllActive().sublist(getPageFirstItem(), getItemsCount()));
						
					} 
				}
			};
		}
		return paginationHelper;
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous(){
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
}
	}
}
