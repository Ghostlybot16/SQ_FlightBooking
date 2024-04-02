package com.ticketBookingAppGroup29_Test;
import com.ticketBookingAppGroup29.*;
import org.junit.Test;

public class BookingTest {
    @Test
    void manageBookingDetails_ShouldSetDetails_WhenGivenFlightAndPreferences() {
        Booking booking = new Booking();
        booking.manageBookingDetails(mockFlightDetails(), mockUserPreferences());
        assertNotNull(booking.getBookingDetails());
    }

    // Mock methods for flight details and user preferences
    private FlightDetails mockFlightDetails() {
        // ... create and return mock FlightDetails ...
    }

    private UserPreferences mockUserPreferences() {
        // ... create and return mock UserPreferences ...
    }
}
