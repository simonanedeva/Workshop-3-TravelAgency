package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleImpl implements Vehicle {

    //Fields
    protected int passengerCapacity;
    protected double pricePerKilometer;
    protected VehicleType type;

    protected static int id;

    //Constructors
    public VehicleImpl (int passengerCapacity, double pricePerKilometer, VehicleType type) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setVehicleType(type);
        id++;
    }

    //Setters

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }
    protected abstract void validatePassengerCapacity(int passengerCapacity);


    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }
    protected abstract void validatePricePerKilometer(double pricePerKilometer);

    //ValidationHelper.validateValueInRange(passengerCap, MIN_PASSENGER_CAP, MAX_PASSENGER_CAP, ERROR_MESSAGE_PASSENGER_CAP);
    //double value, double min, double max, String errorMessage


    private void setVehicleType(VehicleType type) {
        this.type = type;
    }

    //Getters

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String print() {
        return String.format(
                "Passenger capacity: %s\n Price per kilometer: %s\n Vehicle type: %s\n",
                passengerCapacity,
                pricePerKilometer,
                type);
    }

}
