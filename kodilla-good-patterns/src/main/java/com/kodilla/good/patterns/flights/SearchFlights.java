package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFlights {
    private Flights flights;

    public SearchFlights(Flights flights) {
        this.flights = flights;
    }

    public List<Flight> getByDepature(String depature) {
        return flights.getFlightsList().stream()
                .filter(c -> depature.equals(c.getDirections().get(0)))
                .collect(Collectors.toList());
    }

    public List<Flight> getByArrival(String arrival) {
        return flights.getFlightsList().stream()
                .filter(c -> arrival.equals(c.getDirections().get(c.getDirections().size() - 1)))
                .collect(Collectors.toList());
    }

    public List<Flight> getByStopover(String stopover) {
        return flights.getFlightsList().stream()
                .filter(c -> !stopover.equals(c.getDirections().get(0)))
                .filter(c -> !stopover.equals(c.getDirections().get(c.getDirections().size() - 1)))
                .filter(c -> c.getDirections().contains(stopover))
                .collect(Collectors.toList());
    }
}
