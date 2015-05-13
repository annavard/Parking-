package com.company.transaction;

/**
 * Created by anhaytananun on 13.05.15.
 */
public class VehicleTargetStrategy implements TargetStrategy {

    @Override
    public String  retrieveTarget(Transaction transaction) {
        return transaction.getVehicleId();
    }
}
