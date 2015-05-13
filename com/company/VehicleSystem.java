//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//

package com.company;

import com.company.TickerObserver;
import com.company.gps.GPSTrackerController;
import com.company.gps.Location;
import com.company.humanResources.HumanResourceController;
import com.company.humanResources.user.User;
import com.company.lock.SecuritySystemController;
import com.company.property.PropertyController;
import com.company.property.parking.Parking;
import com.company.property.vehicle.Vehicle;
import com.company.transaction.TransactionController;

import java.util.Date;
import java.util.List;

public class VehicleSystem implements TickerObserver {
	private static VehicleSystem sharedSystem;

	private HumanResourceController humanResourceController;
	private PropertyController propertyController;
	private TransactionController transactionController;
	private SecuritySystemController securitySystemController;
	private GPSTrackerController gpsController;

	private VehicleSystem() {
		this.humanResourceController = new HumanResourceController();
		this.propertyController = new PropertyController();
		this.transactionController = new TransactionController();
		this.securitySystemController = new SecuritySystemController();
		this.gpsController = new GPSTrackerController();
	}

	public static VehicleSystem sharedSystem() {
		if (sharedSystem == null) {
			sharedSystem = new VehicleSystem();
		}

		return sharedSystem;
	}

	public boolean register(String fullName, String password, String email, String paymentMethod, String passportSerial, String phoneNumber) {
		return humanResourceController.registerUser(fullName, password, email, paymentMethod, passportSerial, phoneNumber);
	}
	
	public String login(String email, String password) {
		return humanResourceController.loginUser(email, password);
	}
	
	public List<Parking> getParkings() {
		return propertyController.getParkings();
	}
	
	public List<Vehicle> searchInParking(String producer, String parkingId, int minPrice, int maxPrice, int seats, float minVolume, float maxVolume) {
		return propertyController.searchInParking(producer, parkingId, minPrice, maxPrice, seats, minVolume, maxVolume);
	}
	
	public boolean bookVehicle(String userId, String parkingId, String vehicleId, Date bookStart, Date bookEnd) {
		boolean isLoggedIn = humanResourceController.isUserLoggedIn(userId);

		if (!isLoggedIn) {
			return false;
		}

		boolean vehicleExists = propertyController.doVehicleExists(vehicleId, parkingId);

		if (!vehicleExists) {
			return false;
		}
	}
	
	public void unlockMainGate(String tokenId, String email, String password, String lockId) {
	
	}
	
	public void unlockSecondGate(String tokenId, String email, String password, String lockId) {
	
	}
	
	public void unlockVehicle(String tokenId, String email, String password, String lockId) {
	
	}
	
	private void unlockTarget(String tokenId, String email, String password, String lockId, String targetType) {
	
	}
	
	private void notifyCrew(String parkingId) {

		humanResourceController.notifySupportCrew(parkingId, "vehicle was returned");
	
	}
	
	private void notifySecurity(Location location) {

		humanResourceController.notifySecurityCrew(location, "vehicle is overdue");
	}

	@Override
	public void tickMade(Date date) {

	}

	public void activateLock(Sring lockId){


	}
}
