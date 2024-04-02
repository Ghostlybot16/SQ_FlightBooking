package com.Integration_Tests;
import com.ticketBookingAppGroup29.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingIntegrationTest {

    @Test
    public void testBookingProcess() {
        // Setup - create necessary objects and data
        FlightSearch flightSearch = new FlightSearch();
        BookingForm bookingForm = new BookingForm();
        FlightBooker flightBooker = new FlightBooker();

        // Execute - simulate the booking process
        List<Flight> flights = flightSearch.search("NYC", "LAX", "2024-03-15", "2024-03-20", TripType.ROUND_TRIP);
        Flight selectedFlight = flights.get(0);  // Assume the first flight is selected
        UserDetails userDetails = new UserDetails(); // Mock user details
        Booking booking = flightBooker.bookDirectFlight(selectedFlight.getId(), userDetails);

        // Verify - check if booking is successful
        assertNotNull(booking, "Booking should be successful and return a booking instance.");
    }

    @Test
    public void testBookingCancellation() {
        // Setup - create necessary objects and data
        FlightBooker flightBooker = new FlightBooker();
        Booking booking = new Booking(); // Assume this is an existing booking

        // Execute - cancel the booking
        boolean cancellationResult = flightBooker.cancelBooking(booking.getId());

        // Verify - check if cancellation was successful
        assertTrue(cancellationResult, "Booking cancellation should be successful.");
    }
}
