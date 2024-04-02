package com.ticketBookingAppGroup29_Test;
import com.ticketBookingAppGroup29.*;
import org.junit.Test;


public class AvailableFlightsTest {
    @Test
    void displayFlights_ShouldShowFlights_WhenFlightsAreAvailable() {
        AvailableFlights availableFlights = new AvailableFlights();
        availableFlights.displayFlights(mockFlightList());
        assertTrue(availableFlights.getDisplayStatus());
    }

    @Test
    void selectFlight_ShouldSetSelectedFlight_WhenFlightIdIsGiven() {
        AvailableFlights availableFlights = new AvailableFlights();
        availableFlights.selectFlight("FL123");
        assertEquals("FL123", availableFlights.getSelectedFlightId());
    }

    // Helper method to create a list of mock flights
    private List<Flight> mockFlightList() {
        // ... create and return a list of mock Flight objects ...
    }
}
