package QualityGroup.Flight_Booking_System;

import com.flightbooking.model.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightTest {

    @Test
    void testFlightNumber() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        String flightNumber = "DEF456";
        flight.setFlightNumber(flightNumber);
        assertEquals(flightNumber, flight.getFlightNumber());

        assertThrows(NullPointerException.class, () -> flight.setFlightNumber(null));
    }

    @Test
    void testDepartureAirport() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        String departureAirport = "LGA";
        flight.setDepartureAirport(departureAirport);
        assertEquals(departureAirport, flight.getDepartureAirport());

        assertThrows(NullPointerException.class, () -> flight.setDepartureAirport(null));
    }

    @Test
    void testArrivalAirport() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        String arrivalAirport = "EWR";
        flight.setArrivalAirport(arrivalAirport);
        assertEquals(arrivalAirport, flight.getArrivalAirport());

        assertThrows(NullPointerException.class, () -> flight.setArrivalAirport(null));
    }

    @Test
    void testDepartureTime() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        LocalDateTime departureTime = LocalDateTime.now().plusDays(1);
        flight.setDepartureTime(departureTime);
        assertEquals(departureTime, flight.getDepartureTime());

        assertThrows(NullPointerException.class, () -> flight.setDepartureTime(null));
    }

    @Test
    void testArrivalTime() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        LocalDateTime arrivalTime = LocalDateTime.now().plusDays(2);
        flight.setArrivalTime(arrivalTime);
        assertEquals(arrivalTime, flight.getArrivalTime());

        assertThrows(NullPointerException.class, () -> flight.setArrivalTime(null));
    }

    @Test
    void testAvailableSeats() {
        Flight flight = new Flight("ABC123", "LHR", "JFK", LocalDateTime.now(), LocalDateTime.now(), 100);
        int availableSeats = 50;
        flight.setAvailableSeats(availableSeats);
        assertEquals(availableSeats, flight.getAvailableSeats());

        assertThrows(IllegalArgumentException.class, () -> flight.setAvailableSeats(-1));
    }
}