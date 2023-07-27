package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    int id;
    Journey journey;
    double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        setJourney(journey);
        setCosts(costs);
    }

    private void setCosts(double costs) {
        this.costs = costs;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    //TODO
    public double calculatePrice() {
        return costs * JourneyImpl.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }
}

//Journey - the journey the ticket is sold for.
//administrative costs - a number.
//calculatePrice() - calculated by multiplying the administrative costs by the Journey's travel costs.
//Should be convertible to String in the format:
//Ticket ----
//Destination: {destination}
//Price: {price}
