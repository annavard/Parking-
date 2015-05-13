package com.company.property.vehicle;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//




public class MotorBike {
	private boolean hasStroller;
	private int rackNumber;
	private float maxRackLoad;

	public MotorBike(boolean hasStroller, int rackNumber, float maxRackLoad) {
		this.hasStroller = hasStroller;
		this.rackNumber = rackNumber;
		this.maxRackLoad = maxRackLoad;
	}

	public boolean getHasStroller() {
		return hasStroller;
	}
	
	public int getRackNumber() {
		return rackNumber;
	}
	
	public float getMaxRackLoad() {
		return maxRackLoad;
	}

	@Override
	public String toString() {
		return "HAS STROLLER : " + hasStroller + "\n"
				+ "RACK NUMBER : " + rackNumber + "\n"
				+ "RACK LOAD : " + maxRackLoad + "\n";
	}
}
