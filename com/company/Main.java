package com.company;

import com.company.property.parking.Parking;
import com.company.property.vehicle.Vehicle;
import com.company.system.VehicleSystem;
import com.company.ticker.DailyTicker;
import com.company.ticker.TickerObserver;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main implements TickerObserver {
    VehicleSystem system;

    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }

    private void test() {
        system = VehicleSystem.sharedSystem();

        DailyTicker.sharedTicker().attach(this);

        registerUser();
        String userId = loginUser();
        String parkingId = viewParkings();
        String vehicleId = viewVehicles(parkingId);
        bookVehicle(userId, vehicleId, parkingId, false);
        unlockMainGate("TOKEN_1");
        unlockVehicle("TOKEN_2");
        unlockSecondGate("TOKEN_3");
        lockVehicle();
        bookVehicle(userId, vehicleId, parkingId, true);
        unlockMainGate("TOKEN_4");
        unlockVehicle("TOKEN_5");
    }

    private void registerUser() {
        System.out.println();

        boolean registrationSuccess = false;
        String postfix;

        System.out.println("Registering Nick Sargsyan");
        registrationSuccess = system.register("Nick Sargsyan", "qwerty", "nicksargsyan@yahoo.com", "A083EC", "Ak1347", "37499293008");
        postfix = registrationSuccess ? "successfully" : "unsuccessfully";
        System.out.println("Nick Sargsyan registered " + postfix);

        System.out.println("Registering Nick (Other) Sargsyan");
        registrationSuccess = system.register("Nick (Other) Sargsyan", "123456", "nicksargsyan@yahoo.com", "A093EC", "Ak4713", "37499293009");
        postfix = registrationSuccess ? "successfully" : "unsuccessfully";
        System.out.println("Nick (Other) Sargsyan registered " + postfix);
    }

    private String loginUser() {
        System.out.println();

        String userId;
        String postfix;

        System.out.println("Logging in as nicksargsyan@yahoo.com - 098765");
        userId = system.login("nicksargsyan@yahoo.com", "098765");
        postfix = userId == null ? "Unable to login" : ("Logged in as " + userId);
        System.out.println(postfix);

        System.out.println("Logging in as nicksargsyan@yahoo.com - qwerty");
        userId = system.login("nicksargsyan@yahoo.com", "qwerty");
        postfix = userId == null ? "Unable to login" : ("Logged in as " + userId);
        System.out.println(postfix);

        return userId;
    }

    private String viewParkings() {
        System.out.println();
        System.out.println("Get parking list");
        System.out.println();

        List<Parking> parkings = system.getParkings();

        for (Parking parking : parkings) {
            System.out.println(parking);
        }

        return parkings.get(0).getParkingId();
    }

    private String viewVehicles(String parkingId) {
        System.out.println();
        System.out.println("Get vehicle list for parking " + parkingId);
        System.out.println("Search criteria: Subaru, $2000-$3000, 4 seats, 300-400");
        System.out.println();

        List<Vehicle> vehicles = system.searchInParking("Subaru", parkingId, 2000, 3000, 4, 300, 400);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        return vehicles.get(0).getVehicleId();
    }

    private void bookVehicle(String userId, String vehicleId, String parkingId, boolean asViolator) {
        Calendar bookStart = Calendar.getInstance();
        Calendar bookEnd = Calendar.getInstance();

        bookStart.add(Calendar.SECOND, 5);
        bookEnd.add(Calendar.SECOND, asViolator ? 5 : 50);

        System.out.println();
        System.out.println("Book vehicle " + vehicleId + " as " + userId + " from " + bookStart + " to " + bookEnd);
        System.out.println();

        boolean bookSuccess = system.bookVehicle(userId, parkingId, vehicleId, bookStart.getTime(), bookEnd.getTime());
        String message = bookSuccess ? "Booked successfully" : "Book failed";

        System.out.println(message);

        return;
    }

    private void unlockMainGate(String tokenId) {
        System.out.println();
        System.out.println("Unlock Main Gate");
        System.out.println();

        boolean unlockSuccess = system.unlockMainGate(tokenId, "nicksargsyan@yahoo.com", "qwerty", "LOCK_4");
        String message = unlockSuccess ? "Main Gate unlocked successfully" : "Failed to unlock Main Gate";
        System.out.println(message);

        return;
    }

    private void unlockVehicle(String tokenId) {
        System.out.println();
        System.out.println("Unlock Vehicle");
        System.out.println();

        boolean unlockSuccess = system.unlockVehicle(tokenId, "nicksargsyan@yahoo.com", "qwerty", "LOCK_2");
        String message = unlockSuccess ? "Vehicle unlocked successfully" : "Failed to unlock Vehicle";
        System.out.println(message);

        return;
    }

    private void unlockSecondGate(String tokenId) {
        System.out.println();
        System.out.println("Unlock Second Gate");
        System.out.println();

        boolean unlockSuccess = system.unlockSecondGate(tokenId, "nicksargsyan@yahoo.com", "qwerty", "LOCK_6");
        String message = unlockSuccess ? "Second Gate unlocked successfully" : "Failed to unlock Second Gate";
        System.out.println(message);

        return;
    }

    private void lockVehicle() {
        System.out.println();
        System.out.println("Lock vehicle");
        System.out.println();

        system.activateLock("LOCK_2", "No notes");
    }

    @Override
    public  void tickMade(Date date) {
        System.out.println();
        System.out.println("Search for violators and report");
        System.out.println();

        system.solveCase("VEHICLE_2", "Played Grand Theft Auto too much");
    }
}