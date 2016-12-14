package com.bae.oc.services;

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

@Stateless
public class OrderService {

	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
	private ProductManager productManager;

	/**
	 * Checks the basket for the business rules; if any fail it throws an
	 * exception; Otherwise it throws an exception.
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * 
	 */

	public boolean checkBasket(long customerOrderId) {

		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		if (customerOrder.getStatus().equals(Status.BASKET)) {
			if (customerOrder.getOrderLines().size() != 0) {
				if (customerOrder.getCost() <= 10000.00) {
					return true;
				} else {
					// TODO add exception
					return false;
				}
			} else {
				// TODO add exception
				return false;
			}
		} else {
			// TODO add exception
			return false;
		}
	}

	/**
	 * Validate's if something is a basket; if it is, change the order to
	 * Status.Order. If not, throws exception.
	 * 
	 * @param customerOrder
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * 
	 */

	public void confirmOrder(long customerOrderId) {
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);

		if (checkBasket(customerOrderId)) {

			if (customerOrder.getStatus().equals(Status.BASKET)) {

				for (CustomerOrderLine customerOrderLine : customerOrder.getOrderLines()) {
					customerOrderLine.setItemPrice(customerOrderLine.getProduct().getCurrentPrice());
					customerOrderLine.setStatus(Status.ORDER);
				}
				customerOrder.setStatus(Status.ORDER);
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
	 * @return CustomerOrder
	 * 
	 */
	public CustomerOrder getBasket(long customerId) {
		CustomerOrder basket = null;
		Customer customer = customerManager.findById(customerId);
		System.out.println("currentUserId " + customerId);

		try {
			for (CustomerOrder custOrders : customer.getOrders()) {
				if (custOrders.getStatus().equals(Status.BASKET)) {
					basket = custOrders;
					System.out.println("old basket");
				}
			}
		} catch (Exception e) {
			System.out.println(customer.getId());
		}
		if (basket == null) {
			System.out.println("new basket");
			basket = new CustomerOrder();
			List<CustomerOrder> orders = customer.getOrders();
			orders.add(basket);
			customer.setOrders(orders);
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
	 * @param customerOrder
	 * @param productId
	 * 
	 */

	// Depending on how Product is built Product may change to just the product
	// ID being passed as an argument.

	public void addToBasket(long customerOrderId, long productId, Customer customer) {
		Product product = productManager.findProductByPId(productId);
		CustomerOrder customerOrder = getBasket(customer.getId());
		List<CustomerOrderLine> order = customerOrder.getOrderLines();

		order.add(new CustomerOrderLine(customerOrder.getId(), product, 1));
		customerOrder.setOrderLines(order);

		System.out.println("pre update" + customerOrder.getOrderLines().size());

		customerOrderManager.updateCustomerOrder(customer, customerOrder);

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
	 * @param customerOrder
	 * @param product
	 * 
	 */

	// Depending on how Product is built Product may change to just the product
	// ID being passed as an argument.

	public void removeFromBasket(long customerOrderId, long productId, Customer customer) {
		boolean isInBasket = false;
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		int counter = 0;

		for (int i = 0; i < customerOrder.getOrderLines().size(); i++) {
			if (customerOrder.getOrderLines().get(i).getProduct().getId() == productId) {
				isInBasket = true;
				System.out.println("in loop");
				List<CustomerOrderLine> order = customerOrder.getOrderLines();
				order.remove(i);
				customerOrder.setOrderLines(order);

			}
			++counter;
		}

		System.out.println("pre update " + customerOrder.getOrderLines().size());

		customerOrderManager.updateCustomerOrder(customer, customerOrder);

		System.out.println("In the middle");
		if (!isInBasket) {
			System.out.println("notinbasket");
			// TODO add Exception
		}

	}

	/**
	 * First it parses an overloaded method of updateQuantity (which takes a
	 * string) which parses that string into a int. If that is successful, calls
	 * the original method updateQuantity as below. If this check is not
	 * successful, an exception is thrown.
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Tim Spencer
	 * @param customerOrder
	 * @param product
	 * 
	 */

	public void updateQuantity(long customerOrderId, long productId, String quantity) {
		try {
			int quantityInt = Integer.parseInt(quantity);
			updateQuantity(customerOrderId, productId, quantityInt);
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
	 * @param customerOrder
	 * @param product
	 * 
	 */

	public void updateQuantity(long customerOrderId, long productId, int quantity) {
		boolean isInBasket = false;
		CustomerOrder customerOrder = customerOrderManager.findByOrderId(customerOrderId);
		System.out.println(customerOrder.getOrderLines().size());
		if (quantity <= 0) {
			// TODO add Exception
		}

		for (CustomerOrderLine custOrderLine : customerOrder.getOrderLines()) {

			if (custOrderLine.getProduct().getId() == productId) {

				isInBasket = true;
				System.out.println("setting quantity");
				custOrderLine.setQuantity(quantity);
				break;
			}
		}

		if (!isInBasket) {
			System.out.println("not in basket");
			// TODO add Exception
		}

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

}
