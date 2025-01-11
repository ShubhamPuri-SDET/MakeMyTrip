package com.flight.service;

import java.time.LocalDateTime;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flight.model.Booking;
import com.flight.model.Flight;

public class FlightBookingTest {
    private FlightService flightService;
    private BookingService bookingService;

    @BeforeMethod
    void setUp() {
        flightService = new FlightService();
        bookingService = new BookingService(flightService);
    }

    @Test
    void testFlightBooking() {
        // Create a flight
        Flight flight = new Flight("FL123", "New York", "London", 
            LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(7),
            100, 500.0);
        flightService.addFlight(flight);

        // Create a booking
        Booking booking = bookingService.createBooking("FL123", "John Doe", "P123456");
        assertNotNull(booking);
        assertEquals(flight.getAvailableSeats(), 99);

        // Cancel booking
        assertTrue(bookingService.cancelBooking(booking.getBookingId()));
        assertEquals(flight.getAvailableSeats(), 100);
    }
}