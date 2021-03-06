package com.company.property.parking;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import java.util.ArrayList;
import java.util.List;

public class ParkingCatalog {
	private List<Parking> parkings;

	public ParkingCatalog() {
		parkings = new ArrayList<>();
	}

	public void addParking(Parking parking) {
		parkings.add(parking);
	}

	public List<Parking> getParkings() {
		return parkings;
	}
}
