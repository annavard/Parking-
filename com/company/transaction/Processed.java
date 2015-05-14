package com.company.transaction;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import java.util.Date;

public class Processed extends Transaction {
	private String systemFeedbackStatus;
	private String systemFeedbackNotes;

	public Processed(String userId, String vehicleId, String parkingId, Date bookStart, Date bookEnd, String systemFeedbackStatus, String systemFeedbackNotes) {
		super(userId, vehicleId, parkingId, bookStart, bookEnd);

		this.systemFeedbackStatus = systemFeedbackStatus;
		this.systemFeedbackNotes = systemFeedbackNotes;
	}

	public String getSystemFeedbackStatus() {
		return systemFeedbackStatus;
	}
}
