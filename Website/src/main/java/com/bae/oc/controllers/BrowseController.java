/**
 * @author N GILL
 *
 */

package com.bae.oc.controllers;

import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.util.*;
import com.bae.oc.services.*;
import com.bae.oc.entities.*;

@Named("browse")
@ConversationScoped
public class BrowseController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4550533688115713734L;
	@Inject
	private ProductService productService;
	private PaginationHelper paginationHelper;
	private DataModel<Product> products = null;

	private void recreateModel() {
		products = null;

	}

	@SuppressWarnings("unchecked")
	public DataModel<Product> getProducts() {
		if (products==null){
			products = (DataModel<Product>) getPagination().createPageDataModel();
		}
		return products;
	}

	public PaginationHelper getPagination() {
		if (paginationHelper == null) {
			paginationHelper = new PaginationHelper(9) {
				@Override
				public int getItemsCount() {
					return productService.findAllProducts().size();
				}
				 @Override public DataModel<Product>
				 createPageDataModel(){
				 try{
				 return new ListDataModel<Product>(productService.findAllProducts().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
				 }catch (Exception e){
				 return new
				 ListDataModel<Product>(productService.findAllProducts().subList(getPageFirstItem(), getItemsCount()));
				
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

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}

}
