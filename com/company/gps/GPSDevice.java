package com.company.gps;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import com.company.utility.IdGenerator;

public class GPSDevice {
	private static final IdGenerator idGenerator = new IdGenerator("GPS");

	private String gpsDeviceId;
	private String vehicleId;
	private Location location;

	public GPSDevice(String vehicleId, Location location) {
		this.gpsDeviceId = idGenerator.generateId();
		this.vehicleId = vehicleId;
		this.location = location;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public Location getLocation() {
		return location;
	}
}
