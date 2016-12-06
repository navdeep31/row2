package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;
import com.bae.oc.util.LoginService;

@RequestScoped
@Named(value="login")

public class LoginController {
	@Inject
	private CurrentUser currentUser;
	@Inject
	private LoginService login;
	
	private String email = "";
	private String password = "";
	
	public String login() {
		if(!email.isEmpty() && !password.isEmpty())
			if(login.validLogin(email, password))
				currentUser.setCustomer(login.loginUser(email));
		return "home";
	}
	
	public String logout() {
		currentUser.setCustomer(null);
		return "home";
	}
	
	

}
