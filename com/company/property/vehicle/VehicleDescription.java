//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//

package com.company.property.vehicle;

public abstract class VehicleDescription {
	private String producer;
	private int price;

	public VehicleDescription(String producer, int price) {
		this.producer = producer;
		this.price = price;
	}

	public abstract int getSeatNumber();
	public abstract float getMaxVolume();

	public String getProducer() {
		return producer;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "PRODUCER : " + producer + "\n"
				+ "PRICE : " + price + "\n";
	}
}
