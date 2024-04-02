package QualityGroup.Flight_Booking_System;

import com.flightbooking.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightServiceTest {

    private FlightService flightService;
    private DateTimeFormatter formatter;

    @BeforeEach
    public void setUp() {
        flightService = new FlightService();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    @Test
    public void testFindAllFlights() {
        List<Flight> flights = flightService.findAllFlights();
        assertEquals(5, flights.size());
    }

    @Test
    public void testSearchFlights() {
        LocalDateTime departureTime = LocalDateTime.parse("2024-03-15 08:00", formatter);
        List<Flight> flights = flightService.searchFlights("JFK", "LAX", departureTime.format(formatter));
        assertEquals(1, flights.size());
        assertEquals("FL101", flights.get(0).getFlightNumber());
    }

    @Test
    public void testSearchFlightsNotFound() {
        List<Flight> flights = flightService.searchFlights("LHR", "CDG", "2024-03-18 14:00");
        assertEquals(0, flights.size());
    }

    @Test
    public void testSearchFlightsMultipleResults() {
        List<Flight> flights = flightService.searchFlights("LAX", "JFK", "2024-03-16");
        assertEquals(1, flights.size());
        assertEquals("FL102", flights.get(0).getFlightNumber());
    }
}