package com.company.transactionStrategy;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import com.company.transaction.Transaction;

import java.util.Date;

public class IntersectChoiseSubStrategy implements TransactionChoiseSubStrategy {
	private String vehicleId;
	private Date bookEnd;
	private Date bookStart;

	public IntersectChoiseSubStrategy(String vehicleId, Date bookStart, Date bookEnd) {
		this.vehicleId = vehicleId;
		this.bookStart = bookStart;
		this.bookEnd = bookEnd;
	}

	@Override
	public boolean matches(Transaction transaction) {
		return transaction.getVehicleId().equals(vehicleId)
				&& ((transaction.getBookStart().before(bookStart) && transaction.getBookEnd().after(bookEnd))
					|| (transaction.getBookStart().before(bookStart) && transaction.getBookEnd().after(bookStart))
					|| (transaction.getBookStart().before(bookEnd) && transaction.getBookEnd().after(bookEnd)));
	}
}