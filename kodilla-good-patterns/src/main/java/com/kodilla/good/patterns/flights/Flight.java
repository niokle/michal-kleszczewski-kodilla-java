package com.kodilla.good.patterns.flights;

import java.util.*;

public class Flight {
    private int number;
    private List<String> directions = new ArrayList<>();

    public Flight(int number, String[] directions) {
        this.number = number;
        this.directions = Arrays.asList(directions);
    }

    public int getNumber() {
        return number;
    }

    public List<String> getDirections() {
        return directions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getNumber() == flight.getNumber() &&
                Objects.equals(getDirections(), flight.getDirections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getDirections());
    }
}


