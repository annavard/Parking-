package com.company.property.vehicle;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


public class MotorBikeAdapter extends VehicleDescription {
	private MotorBike motorBike;

	public MotorBikeAdapter(String producer, int price, MotorBike motorBike) {
		super(producer, price);

		this.motorBike = motorBike;
	}

	@Override
	public int getSeatNumber() {
		int stroller = motorBike.getHasStroller() ? 1 : 0;
		return 1 + stroller;
	}

	@Override
	public float getMaxVolume() {
		return motorBike.getMaxRackLoad() * motorBike.getRackNumber();
	}

	@Override
	public String toString() {
		return super.toString() + motorBike.toString();
	}
}
