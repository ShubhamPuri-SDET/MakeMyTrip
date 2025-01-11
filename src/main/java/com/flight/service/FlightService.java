package com.flight.service;

import com.flight.model.Flight;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FlightService {
    private Map<String, Flight> flights = new HashMap<>();

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    public List<Flight> searchFlights(String origin, String destination, LocalDateTime date) {
        return flights.values().stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin)
                        && f.getDestination().equalsIgnoreCase(destination)
                        && f.getDepartureTime().toLocalDate().equals(date.toLocalDate())
                        && f.getAvailableSeats() > 0)
                .collect(Collectors.toList());
    }

    public List<Flight> getAvailableFlights() {
        return flights.values().stream()
                .filter(f -> f.getAvailableSeats() > 0)
                .collect(Collectors.toList());
    }
}