package com.flight.model;

import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private String passengerName;
    private String passportNumber;
    private Flight flight;
    private LocalDateTime bookingTime;
    private BookingStatus status;

    public Booking(String bookingId, String passengerName, String passportNumber, Flight flight) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.flight = flight;
        this.bookingTime = LocalDateTime.now();
        this.status = BookingStatus.CONFIRMED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}

enum BookingStatus {
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled");

    private final String description;

    BookingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}