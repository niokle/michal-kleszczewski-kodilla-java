package com.kodilla.good.patterns.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchFlightsTestSuite {
    @Test
    public void testSearchFlights() {
        //given
        Flight flight1 = new Flight(1, new String[]{"Warszawa","Gdansk","Szczecin"});
        Flight flight2 = new Flight(2, new String[]{"Szczecin","Warszawa","Lodz"});
        Flight flight3 = new Flight(3, new String[]{"Szczecin","Gdansk","Warszawa"});
        Flight flight4 = new Flight(4, new String[]{"Koszalin","Krakow","www","Gdansk","Lodz"});
        Flight flight5 = new Flight(5, new String[]{"Rzeszow","Warszawa","Gdansk"});
        Flight flight6 = new Flight(6, new String[]{"Poznan","Gdansk","Lodz"});
        Flights flights = new Flights();
        flights.addFlight(flight1);
        flights.addFlight(flight2);
        flights.addFlight(flight3);
        flights.addFlight(flight4);
        flights.addFlight(flight5);
        flights.addFlight(flight6);
        SearchFlights searchFlights = new SearchFlights(flights);

        //when
        List<Flight> byDepatureList = searchFlights.getByDepature("Szczecin");
        List<Flight> byArrivalList = searchFlights.getByArrival("Lodz");
        List<Flight> byStopoverList = searchFlights.getByStopover("Gdansk");

        //then
        Assert.assertEquals(2, byDepatureList.size());
        Assert.assertEquals(3, byArrivalList.size());
        Assert.assertEquals(4, byStopoverList.size());
    }
}
