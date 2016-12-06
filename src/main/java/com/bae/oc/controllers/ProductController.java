/**
 * @author N GILL
 *
 */

package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;

import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.entities.Product;
import com.bae.oc.services.ProductService;

@Named("products")
@Path("/products")
@RequestScoped
public class ProductController {

	@Inject
	private SelectedProduct selectedProduct;

	@Inject
	private ProductService productService;

	public String select(long productId){
		Product product = productService.findProductByPId(productId);
		if (product != null){
			selectedProduct.setProduct(product); //selected product controller
			return "product";
		}
		return "browse";
	}
}
