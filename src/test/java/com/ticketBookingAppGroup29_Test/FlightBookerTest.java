package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class FlightBookerTest {
    @Test
    void bookDirectFlight_ShouldCreateBooking_WhenFlightIdAndUserDetailsProvided() {
        FlightBooker flightBooker = new FlightBooker();
        BookingDetails bookingDetails = flightBooker.bookDirectFlight("FL123", mockUserDetails());
        assertNotNull(bookingDetails);
    }
}
