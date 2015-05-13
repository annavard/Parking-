package com.company.transactionStrategy;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import com.company.transaction.Transaction;

public class OwnerChoiseStrategy implements TransactionChoiseStrategy {
	private String userId;

	public OwnerChoiseStrategy(String userId) {
		this.userId = userId;
	}

	@Override
	public boolean matches(Transaction transaction) {
		return transaction.getUserId().equals(userId);
	}
}