package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        validateCarts(carts);
        this.carts = carts;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= PASSENGER_MIN_VALUE || passengerCapacity >= PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A train cannot have less than %d passengers or more than %d passengers.\n", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
    }


    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer <= PRICE_MIN_VALUE || pricePerKilometer >= PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A vehicle with a price per kilometer lower than $%f or higher than $%f cannot exist!\n", PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }

    protected void validateCarts(int carts) {
        if (carts <= CARTS_MIN_VALUE || carts >= CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Carts with value lower than %d or higher than %d cannot exist!\n", CARTS_MIN_VALUE, CARTS_MAX_VALUE));
        }
    }

    @Override
    public String print() {
        return String.format("Train ----\n %s\n Carts:%d\n", super.print(), carts);
    }

}