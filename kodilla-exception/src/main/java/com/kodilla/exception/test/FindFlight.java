package com.kodilla.exception.test;

public class FindFlight {
    public static void main(String[] args) {
        Airport airport = new Airport();

        airport.addFlight("New York, JFK", true);
        airport.addFlight("Paris, Charles de Gaulle", true);
        airport.addFlight("Canada, Community", true);

        Flight flight = new Flight("Warsaw, Chopin", "Chicago, Midway");

        try {
            airport.findFlight(flight);
        } catch (RouteNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
