package com.bae.oc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * 
 * Service for the Order Lifecycle
 * 
 * @author Andrew Claybrook
 * @author Tim Spencer
 * 
 * @version 0.1
 * 
 */

import javax.inject.Inject;

import com.bae.oc.entities.Customer;
import com.bae.oc.entities.CustomerOrder;
import com.bae.oc.entities.CustomerOrderLine;
import com.bae.oc.entities.Product;
import com.bae.oc.enums.Status;
import com.bae.oc.managers.CustomerManager;
import com.bae.oc.managers.CustomerOrderManager;
import com.bae.oc.managers.ProductManager;


/**
 * 
 * 
 * @author Somebody
 * @author Alex Dawson
 * @version 0.2 11/01/2017
 *
 */
@Stateless
public class OrderService {

	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
	private ProductManager productManager;

	/**
	 * Checks if the basket is valid to order (follows business rules)
	 * If any fail it throws an exception
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 */

	public boolean isValidBasketToOrder(CustomerOrder iCustomerOrder) {
		
		// Check if order is a basket
		if (!iCustomerOrder.getStatus().equals(Status.BASKET)) {
			// TODO add exception 
		}
		
		// Check if order is non-empty
		if (iCustomerOrder.getOrderLines().size() == 0) {
			// TODO add exception
		}
		
		// Check if order is less than max cost
		if (iCustomerOrder.getCost() > 10000.00) {
			// TODO add exception
		}
		
		return true;
	}

	/**
	 * Validate's if something is a basket; if it is, change the order to
	 * Status.Order.
	 * 
	 * If not, throws exception.
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 */

	public void confirmOrder(CustomerOrder iCustomerOrder) {

		if (isValidBasketToOrder(iCustomerOrder)) {

			if (iCustomerOrder.getStatus().equals(Status.BASKET)) {

				for (CustomerOrderLine customerOrderLine : iCustomerOrder.getOrderLines()) {
					customerOrderLine.setItemPrice(customerOrderLine.getProduct().getCurrentPrice());
					customerOrderLine.setStatus(Status.ORDERED);
				}
				iCustomerOrder.setStatus(Status.ORDERED);
				iCustomerOrder.setOrderDate(LocalDateTime.now());
			} else {
				// TODO add exception
			}
		} else {
			// TODO add exception
		}

	}

	/**
	 * 
	 * Checks if customer has an open basket. If they do, the open basket is
	 * returned. If not then a new empty basket is created for the customer and
	 * returned.
	 * 
	 * @param customer
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * @return CustomerOrder
	 * 
	 */
	public CustomerOrder getBasket(Customer iCustomer) {
		CustomerOrder basket = null;
		
		//DEBUG
		System.out.println("currentUserId " + iCustomer.getId());

		try {
			for (CustomerOrder order : iCustomer.getOrders()) {
				if (order.getStatus().equals(Status.BASKET)) {
					basket = order;
					System.out.println("Customer with ID " + iCustomer.getId() + " has existing basket with status " + order.getStatus());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception getting basket for Customer with ID " + iCustomer.getId());
		}
		
		// If there is no existing basket
		if (basket == null) {
			System.out.println("Customer with ID " + iCustomer.getId() + " has no existing basket");
			
			// Add new basket to customer's list of orders
			basket = new CustomerOrder();
			List<CustomerOrder> orders = iCustomer.getOrders();
			orders.add(basket);
			iCustomer.setOrders(orders);
		}

		return basket;
	}

	/**
	 * 
	 * Matches and gets product object from ProductManager. Iterates through the
	 * Customer Order's Customer Order Line to check if the Product ID already
	 * exists within, if so an exception will be thrown. After iteration if
	 * boolean isAlreadyInBasket is proven to be still false then new Customer
	 * Order Line entry is created and added back to the Customer Order
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 * @param customerOrder
	 * @param productId
	 * 
	 */

	// Depending on how Product is built Product may change to just the product
	// ID being passed as an argument.

	public void addToBasket(CustomerOrder iCustomerOrder, Product iProduct) {
		List<CustomerOrderLine> orderLines = iCustomerOrder.getOrderLines();

		orderLines.add(new CustomerOrderLine(iCustomerOrder.getId(), iProduct, 1));
		iCustomerOrder.setOrderLines(orderLines);

		System.out.println("Number of order lines before update: " + iCustomerOrder.getOrderLines().size());

		customerOrderManager.updateCustomerOrder(iCustomerOrder);

		/*
		 * boolean isAlreadyInBasket = false;
		 * 
		 * for (CustomerOrderLine custOrderLine : customerOrder.getOrderLines())
		 * { if (custOrderLine.getProduct().getProductID() == productId) {
		 * isAlreadyInBasket = true; // TODO add Exception } }
		 * 
		 * if (!isAlreadyInBasket) {
		 * 
		 * customerOrder.getOrderLines().add(new
		 * CustomerOrderLine(customerOrder.getId(), product, 1)); }
		 */

	}

	/**
	 * 
	 * Iterates through the Customer Order Line attached to the Customer Order
	 * that has being passed to check if the Product ID passed exists within the
	 * Customer Order Line If this check is successful this removes the Customer
	 * Order Line. If this check is not successful an exception is thrown
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor
	 * 
	 * @param customerOrder
	 * @param product
	 * 
	 */

	public void removeFromBasket(CustomerOrder iOrder, String iLineNumber) {
		
		try {
			int lineNumber = Integer.parseInt(iLineNumber);
			removeFromBasket(iOrder, lineNumber);
		} catch (NumberFormatException e) {
			System.out.println("number format exception");
			// TODO Exception
		}
		
	}
	
	// Depending on how Product is built Product may change to just the product
	// ID being passed as an argument.

	public void removeFromBasket(CustomerOrder iOrder, int iLineNumber) {
		
		List<CustomerOrderLine> orderLines = iOrder.getOrderLines();
		
		orderLines.remove(iLineNumber);
		
		iOrder.setOrderLines(orderLines);

		//DEBUG
		System.out.println("Number of order lines before update:  " + iOrder.getOrderLines().size());

		customerOrderManager.updateCustomerOrder(iOrder);

	}

	/**
	 * First it parses an overloaded method of updateQuantity (which takes a
	 * string) which parses that string into a int. If that is successful, calls
	 * the original method updateQuantity as below. If this check is not
	 * successful, an exception is thrown.
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 * @param customerOrder
	 * @param product
	 * 
	 */

	public void updateQuantity(CustomerOrder iOrder, String iLineNumber, List<String> iQuantities) {
		try {
			
			int lineNumber = Integer.parseInt(iLineNumber);
			int quantity = Integer.parseInt(iQuantities.get(lineNumber));
			updateQuantity(iOrder, lineNumber, quantity);
		} catch (NumberFormatException e) {
			System.out.println("number format exception");
			// TODO Exception
		}

	}
	
	public void updateQuantity(CustomerOrder iOrder, int iLineNumber, List<String> iQuantities) {
		try {
			int quantity = Integer.parseInt(iQuantities.get(iLineNumber));
			updateQuantity(iOrder, iLineNumber, quantity);
		} catch (NumberFormatException e) {
			System.out.println("number format exception");
			// TODO Exception
		}

	}

	/**
	 * Iterates through the Customer Order Line attached to the Customer Order
	 * that has being passed to check if the Product ID passed exists within the
	 * Customer Order Line If this check is successful this sets the quantity to
	 * the value that has been passed. If this check is not successful an
	 * exception is thrown.
	 * 
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @MethodAuthor Alex Dawson
	 * 
	 */

	public void updateQuantity(CustomerOrder iOrder, int iLineNumber, int iQuantity) {
		
		//DEBUG
		System.out.println("Number of order lines: " + iOrder.getOrderLines().size());
		
		if (iQuantity <= 0) {
			// TODO add Exception
		}
		
		//Assume line number is 0-indexed
		
		iOrder.getOrderLines().get(iLineNumber).setQuantity(iQuantity);

	}

	/*
	 * When Customers & Addresses are finalised build create validation for
	 * addresses public boolean hasAddress(Customer customer){ return false; }
	 */

	/**
	 * 
	 * A blank List of type CustomerOrder is created to allow adding of Customer
	 * Order objects. The Customer Order objects attached to the Customer are
	 * then iterated through to check the status does not equal BASKET. If this
	 * check is successful an exception is thrown
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customer
	 * @param orderHistory
	 * 
	 */

	public List<CustomerOrder> getOrderHistory(long customerId) {
		List<CustomerOrder> orderHistory = new ArrayList<CustomerOrder>();
		Customer customer = customerManager.findById(customerId);

		for (CustomerOrder custOrders : customer.getOrders()) {
			if (custOrders.getStatus() != Status.BASKET) {
				orderHistory.add(custOrders);
			}
		}

		if (customer.getOrders().size() == 0 || orderHistory.size() == 0) {
			// TODO add Exception
		}
		return orderHistory;
	}
	
	/**
	 * 
	 * The method is passed the customerOrderId which is passed to the findByOrderId query to obtain the customer object that this Id belongs to.
	 * The status associated with the Customer Order object is then passed to a switch statement 
	 * Depending on the Enum that is current set this will return an int of a certain value to be used by the progress bar within the orderhistory.xhtml page
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @param status
	 * 
	 */
	
	public int getStatusValue(long customerOrderId) {
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		int status = 0;
		switch (customerOrder.getStatus()){
			case BASKET: break;
			case ORDERED:
				status = 25;
				break;
			case DISPATCHED:
				status = 50;
				break;
			case DELIVERED:
				status = 75;
				break;
			case PAID:
				status = 100;
				break;
		}
		return status;
	}

}
