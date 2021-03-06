/**
 * @author N GILL
 *
 */

package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

	
	/**
	 * Sets the the selected product to the product accessed by user
	 * 
	 * @return A string to navigate to the correct web page
	 * 
	 * @MethodAuthor N Gill
	 * 
	 */
	public String select(long productId){
		Product product = productService.findProductByPId(productId);
		if (product != null){
			selectedProduct.setProduct(product); //selected product controller
			return "productPage";
		}
		return "browse";
	}
	
	/*@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product select(@PathParam("id") String productId) {
		return productService.findProductByPId(productId);
	}*/
}
