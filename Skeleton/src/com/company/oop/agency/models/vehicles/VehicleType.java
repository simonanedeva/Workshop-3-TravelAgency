package com.company.oop.agency.models.vehicles;

public enum VehicleType {
    LAND,
    AIR,
    SEA;

    @Override
    public String toString() {
        switch (this) {
            case AIR:
                return "Air";
            case SEA:
                return "Sea";
            case LAND:
                return "Land";
            default:
                throw new IllegalArgumentException();
        }
    }

}