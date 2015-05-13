package com.company.transactionStrategy;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import com.company.transaction.Transaction;

import java.util.List;

public class ExistChoiseStrategy implements TransactionChoiseStrategy {
	private List<TransactionChoiseSubStrategy> substrategies;

	@Override
	public boolean matches(Transaction transaction) {
		boolean matches = true;

		for (TransactionChoiseSubStrategy subStrategy : substrategies) {
			matches = matches && subStrategy.matches(transaction);
		}

		return matches;
	}
	
	public void add(TransactionChoiseSubStrategy substrategy) {
		substrategies.add(substrategy);
	}
}