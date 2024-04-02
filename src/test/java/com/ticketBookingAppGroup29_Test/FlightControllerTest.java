package QualityGroup.Flight_Booking_System;

import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @Test
    public void testBookingPage() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC123", "New York", "London", "2023-03-01"));
        flights.add(new Flight("XYZ456", "Los Angeles", "Tokyo", "2023-03-02"));

        when(flightService.findAllFlights()).thenReturn(flights);

        String result = flightController.bookingPage(null);
        assertEquals("redirect:/booking.html", result);
    }

    @Test
    public void testSearchFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC123", "New York", "London", "2023-03-01"));
        flights.add(new Flight("XYZ456", "Los Angeles", "Tokyo", "2023-03-02"));

        when(flightService.searchFlights("New York", "London", "2023-03-01")).thenReturn(flights);

        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return this;
            }
        };

        String result = flightController.searchFlights("New York", null, null, "London", "2023-03-01", model);
        assertEquals("booking", result);
    }
}