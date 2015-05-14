package com.company.humanResources.user;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import java.util.ArrayList;
import java.util.List;

public class UserCatalog {
	private List<User> users;

	public UserCatalog() {
		this.users = new ArrayList<>();
	}

	public boolean register(String  fullName, String password, String email, String paymentMethod, String passportSerial, String phoneNumber) {
		for (User user : users) {
			if (user.coincides(passportSerial, phoneNumber, paymentMethod, email)) {
				return false;
			}
		}

		User newUser = new User(fullName, password, email, paymentMethod, passportSerial, phoneNumber);
		users.add(newUser);

		return true;
	}
	
	public User findUser(String email, String password) {
		for (User user : users) {
			if (user.canAuth(email, password)) {
				return user;
			}
		}

		return null;
	}

	public User findUser(String userId) {
		for (User user : users) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}

		return null;
	}
	
	public boolean isUserLoggedIn(String userId) {
		for (User user : users) {
			if (user.getUserId().equals(userId) && user.getIsLoggedIn()) {
				return true;
			}
		}

		return false;
	}
}
