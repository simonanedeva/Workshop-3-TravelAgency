package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    protected boolean hasFreeFood;

    //Constructor
    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(passengerCapacity, pricePerKilometer, VehicleType.AIR);
        setHasFreeFood(hasFreeFood);
    }

    private void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }


    @Override
    public boolean hasFreeFood() {
        return false;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= PASSENGER_MIN_VALUE || passengerCapacity >= PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("An airplane cannot have less than %d passengers or more than %d passengers.\n", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
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
        return String.format(
                "Airplane ----\n %s\n Has free food: %s\n", super.print(), hasFreeFood);
    }

    //Airplane ----
    //Passenger capacity: {capacity}
    //Price per kilometer: {pricePerKilometer}
    //Vehicle type: {vehicleType}
    //Has free food: {hasFreeFood}

    //    @Override
    //    public String print() {
    //        return String.format(
    //                "%s" +
    //                " #Milliliters: %d\n" +
    //                " #Usage: %s\n",
    //                super.print(),
    //                millilitres,
    //                usageType);
    //    }

}