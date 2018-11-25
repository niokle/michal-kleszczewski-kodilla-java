package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class Airport {
    private Map<String, Boolean> flights = new HashMap<>();

    public void addFlight(String destination, boolean availability) {
        flights.put(destination,availability);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        if (!flights.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Nie ma takiego lotu");
        }
        System.out.println(flight.getArrivalAirport() + " " + flights.get(flight.getArrivalAirport()));
    }
}
