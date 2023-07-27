package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {

    int id;
    String startLocation;
    String destination;
    int distance;
    Vehicle vehicle;

    double costs;

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        this.id = id;
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;
    }

    private void setDistance(int distance) {
        if(distance < DISTANCE_MIN_VALUE || distance > DISTANCE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("The Distance cannot be less than %s or more than %s kilometers.", DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE));
        }
        this.distance = distance;
    }

    private void setDestination(String destination) {
        if(destination.length() < DESTINATION_MIN_LENGTH || destination.length() > DESTINATION_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("The Destination's length cannot be less than %s or more than %s symbols long", DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH));
        }
        this.destination = destination;
    }

    private void setStartLocation(String startLocation) {
        if(startLocation.length() < START_LOCATION_MIN_LENGTH || startLocation.length() > START_LOCATION_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("The StartingLocation's length cannot be less than %s or more than %s symbols long.", START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH));
        }
        this.startLocation = startLocation;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    public double getCosts() {
        return costs;
    }


    @Override
    public double calculateTravelCosts() {
        return costs = distance* vehicle.getPricePerKilometer();
    }

    public String print() {
        return String.format(
                "Journey ----\n Destination: %s\n Distance: %s\n Vehicle type: %s\n Travel costs: %f\n",
                destination, distance, vehicle, costs);
    }

}