package com.bae.oc.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.controllers.session.SelectedProduct;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;
import com.bae.oc.entities.Product;
import com.bae.oc.services.OrderService;

/**
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 * @author Alex Dawson
 *
 * @version 0.2 11/01/2017
 */

@Named("basket")
@SessionScoped
public class BasketController implements Serializable {

	private static final long serialVersionUID = -8664519487305604764L;

	@Inject
	private OrderService orderService;
	@Inject
	private CurrentUser currentUser;
	@Inject
	private SelectedProduct selectedProduct;

	private CustomerOrder basket;
	private List<String> quantities = new ArrayList<String>();
	private int lineNumber = 0;

	public int getLineNumber() {
		return lineNumber;
	}


	public void setSelectedProduct() {
		selectedProduct.setProduct(basket.getOrderLines().get(lineNumber).getProduct());
	}
	
	/**
	 * Iterates line number
	 * 
	 * @MethodAuthor Somebody
	 * @MethodAuthor Alex Dawson
	 * 
	 * @return
	 */
	public String iterateLineNumber() {
		if (lineNumber != basket.getOrderLines().size() - 1) {
			lineNumber++;
		}

		return "";
	}

	/**
	 * Method firstly uses theisLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. If not they are returned
	 * to the login page productId and customerOrderId are set from calling the
	 * getProductID() getter from selectedProduct session controller and
	 * getBasket() method from the orderService
	 *
	 * Once this is set then the addToBasket() is called passing the productId
	 * and customerOrderId variables
	 *
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 * @return String
	 */

	public String checkOutBasket() {
		if (currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		if(orderService.isValidBasketToOrder(basket)) {
			return "order-details";
		} else {
			
		}
		
		
		return null;
	}
	
	public String addToBasket() {

		if (currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		if (basket == null) {
			setBasket();
		}
		
		orderService.addToBasket(basket, selectedProduct.getProduct());
		
		return "";
	}
	
	public String addToBasket(Product product) {

		if (currentUser.isLoggedIn() == false) {
			return "login";
		}
		
		if (basket == null) {
			setBasket();
		}
		
		orderService.addToBasket(basket, product);
		
		return "";
	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. If not they are returned
	 * to the login page productId and customerOrderId are set from calling the
	 * getProductID() getter from selectedProduct session controller and
	 * getBasket() method from the orderService
	 *
	 * Once this is set then the removeFromBasket() is called passing the
	 * productId and customerOrderId variables
	 *
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 * @return String
	 */

	public String removeFromBasket() {
		System.out.println("Removing from basket");
		if (currentUser.isLoggedIn() == false) {
			return "login";
		} else {
			System.out.println("remove from basket");
			orderService.removeFromBasket(basket, lineNumber);

			return "basket";
		}
	}
	
	public String removeFromBasket(int iLineNumber) {
		System.out.println("Removing from basket");
		if (currentUser.isLoggedIn() == false) {
			return "login";
		} else {
			System.out.println("remove from basket");
			orderService.removeFromBasket(basket, iLineNumber);

			return "basket";
		}
	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson 
	 * 
	 * @return String
	 */

	public String setBasket() {
		if (currentUser.isLoggedIn() == false) {
			return "";
		} else {
			
			
			basket = orderService.getBasket(currentUser.getCustomer());
			basket.getOrderLines().size();
			lineNumber = 0;
			return "";
		}
	}
	/*
	 * May be used later, used specifically for gatekeeping use of the basket
	 * button. Redundant now thanks to above method.
	 * 
	 * public String checkBasketButton() { if(currentUser.isLoggedIn() == false)
	 * { return "login"; } else { return "basket"; } }
	 */

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 * @param String
	 * @return String
	 */
	public String updateQuantity() {
		System.out.println("update quantity");
		if (currentUser.isLoggedIn() == false) {
			return "login";
		}
		try {			
			orderService.updateQuantity(basket, lineNumber, quantities);
			return "basket";
		} catch (Exception e) {
			System.out.println("fail");
			return "placeholder";
		}

	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param String
	 * @return String
	 */

	public CustomerOrder getBasket() {
		return basket;
	}

	/**
	 *
	 * Gets the first product in the list of products (currently)
	 *
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */

	public String getProductName() {
		return basket.getOrderLines().get(0).getProduct().getName();
	}

	/**
	 *
	 * Turns the basket's total cost to a string
	 *
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * @return String
	 */

	public String getTotalCost() {
		return basket.getCostString();
	}

	/**
	 * 
	 * Turns the first line to a totalLinePrice
	 * 
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * @return String
	 */

	public String getLineCost() {
		int pricePence = basket.getOrderLines().get(lineNumber).getTotalLinePrice();
		return "£" + (pricePence / 100) + "." + (pricePence % 100);
	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */

	public String getQuantity() {
		System.out.println("quantity");
		return "" + basket.getOrderLines().get(lineNumber).getQuantity();
	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * @return String
	 */

	public String getItemPrice() {
		int pricePence = basket.getOrderLines().get(lineNumber).getProduct().getCurrentPrice();
		return "£" + (pricePence / 100) + "." + (pricePence % 100);
	}

	/**
	 * Method firstly uses the isLoggedIn() method from the CurrentUser Session
	 * Controller to determine if a user is logged in. This method then sets the
	 * basket attribute from the current user's id and calling orderService's
	 * get basket method.
	 *
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	
	public List<String> getQuantities() {
		List<CustomerOrderLine>orderLines = basket.getOrderLines();
		if(quantities.size() != orderLines.size()) {
			quantities.clear();
			for(CustomerOrderLine orderLine: orderLines) {
				quantities.add(String.valueOf(orderLine.getQuantity()));
			}
		}
		return this.quantities;
	}
	
	public void setQuantities(List<String> iQuantities) {
		this.quantities = iQuantities;
	}

	public long getProductId() {
		System.out.println("getting product id");
		return basket.getOrderLines().get(lineNumber).getProduct().getId();
	}
	
	public String getSize() {
		return String.valueOf( basket.getOrderLines().size() );
	}

}
