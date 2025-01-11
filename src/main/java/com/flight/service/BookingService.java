package com.flight.service;

import com.flight.model.Booking;
import com.flight.model.Flight;
import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private Map<String, Booking> bookings = new HashMap<>();
    private FlightService flightService;

    public BookingService(FlightService flightService) {
        this.flightService = flightService;
    }

    public Booking createBooking(String flightNumber, String passengerName, String passportNumber) {
        Flight flight = flightService.getFlight(flightNumber);
        if (flight != null && flight.bookSeat()) {
            String bookingId = UUID.randomUUID().toString();
            Booking booking = new Booking(bookingId, passengerName, passportNumber, flight);
            bookings.put(bookingId, booking);
            return booking;
        }
        return null;
    }

    public boolean cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.getFlight().cancelSeat();
            booking.setStatus(BookingStatus.CANCELLED);
            return true;
        }
        return false;
    }

    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public List<Booking> getBookingsByPassenger(String passengerName) {
        return bookings.values().stream()
                .filter(b -> b.getPassengerName().equalsIgnoreCase(passengerName))
                .collect(Collectors.toList());
    }
}