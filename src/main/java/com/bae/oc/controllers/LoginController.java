package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.services.LoginService;

/**
 * Controller handling login
 * 
 * @author Andrew Claybrook
 * @author Alex Dawson
 * @version 0.2 06/12/2016
 */
@Named("login")
@RequestScoped
public class LoginController {
	
	@Inject
	private CurrentUser currentUser;
	@Inject
	private LoginService loginService;
	
	private String email = "";
	private String password = "";
	
	/**
	 * Attempts login with non-empty email and password
	 * 
	 * Returns to homepage on completion
	 * 
	 * @return String of next page to visit
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Alex Dawson
	 */
	public String login() {
		if(!email.isEmpty() && !password.isEmpty()){
			if(loginService.validLogin(this.email, this.password)) {
				currentUser.setCustomer(loginService.loginUser(email));
				return "home";
			}
		}
		return "home";
	}
	
	/**
	 * Logs user out (represented by setting to null)
	 * 
	 * Then sends to homepage
	 * 
	 * @return String of next page to visit
	 * 
	 * @MethodAuthor Andrew Claybrook
	 * @MethodAuthor Alex Dawson
	 */
	public String logout() {
		currentUser.setCustomer(null);
		return "home";
	}
	
	/**
	 * Returns email
	 * 
	 * @return Email
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets email
	 * @param iEmail Email passed from form
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setEmail(String iEmail) {
		this.email = iEmail;
	}
	
	/**
	 * Returns password
	 * 
	 * @return Password
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets password
	 * 
	 * @param iPassword Password passed from form
	 * 
	 * @MethodAuthor Alex Dawson
	 */
	public void setPassword(String iPassword) {
		this.password = iPassword;
	}
	

}
