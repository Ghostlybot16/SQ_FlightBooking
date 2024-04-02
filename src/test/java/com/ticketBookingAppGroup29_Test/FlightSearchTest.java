package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class FlightSearchTest {
    @Test
    void search_ShouldReturnFlights_WhenGivenValidInput() {
        FlightSearch flightSearch = new FlightSearch();
        List<Flight> results = flightSearch.search("NYC", "LAX", "2024-01-01", "2024-01-05", TripType.ROUND_TRIP);
        assertFalse(results.isEmpty());
    }
}
