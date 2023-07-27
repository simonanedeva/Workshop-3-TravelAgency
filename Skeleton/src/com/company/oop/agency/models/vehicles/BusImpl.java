package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity,pricePerKilometer,VehicleType.LAND);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= PASSENGER_MIN_VALUE || passengerCapacity >= PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A bus cannot have less than %d passengers or more than %d passengers.\n", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer <= PRICE_MIN_VALUE || pricePerKilometer >= PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A vehicle with a price per kilometer lower than $%f or higher than $%f cannot exist!\n", PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }

    @Override
    public String print() {
        return String.format("Bus ----\n %s\n", super.print());
    }

}