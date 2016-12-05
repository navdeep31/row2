package com.bae.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bae.oc.controllers.session.CurrentUser;

@RequestScoped
@Named(value="register")
public class CreateAccountController {

		// private RegistrationService registrationService;
		@Inject
		private CurrentUser currentUser;
		private String firstName = "";
		private String lastName = "";
		private String email = "";
		private String password = "";
		private String addressLine1 = "";
		private String addressLine2 = "";
		private String town = "";
		private String postcode = "";
		
	
		
		public CurrentUser getCurrentUser() {
			return currentUser;
		}
		public void setCurrentUser(CurrentUser currentUser) {
			this.currentUser = currentUser;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getTown() {
			return town;
		}
		public void setTown(String town) {
			this.town = town;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}

		
}
