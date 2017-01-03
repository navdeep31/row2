package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.LoginService;

/**
 * 
 * @author Tim Spencer
 *
 */
@RequestScoped
@Named("login")
public class LoginController {
	@Inject
	CurrentUser currentUser;
	
	@Inject
	LoginService loginService;
	
	String email;
	
	String password;

	/**
	 * 
	 * Logs user in, using current user session controller;
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	public String login() {
		currentUser.setEmployee(loginService.loginEmployee(email, password));
		
		if(currentUser.isLoggedIn()) {
			return "home";
		} 
		
		return "login";
	}
	
	/**
	 * 
	 * Logs user out, using current user session controller;
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	public String logout() {
		if(currentUser.isLoggedIn()){
			currentUser.setEmployee(null);
		} 
		
		return "login";
	}
	
	
	/**
	 * 
	 * Gets password entered by user.
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * Sets the password as entered by user. 
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * Gets the email to be displayed.
	 * 
	 * @MethodAuthor Tim Spencer
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	
}
