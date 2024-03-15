import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AvailableFlightsIntegrationTest {

    @Test
    public void testFlightAvailabilityAfterBooking() {
        // Setup - create necessary instances
        FlightSearch flightSearch = new FlightSearch();
        FlightBooker flightBooker = new FlightBooker();

        // Execute - search for a flight, book it, and check availability
        List<Flight> flights = flightSearch.search("NYC", "LAX", "2024-03-15", "2024-03-20", TripType.ROUND_TRIP);
        Flight selectedFlight = flights.get(0);  // Assume the first flight is selected
        flightBooker.bookDirectFlight(selectedFlight.getId(), new UserDetails()); // Mock user details
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        boolean isAvailable = availabilityChecker.checkFlightAvailability(selectedFlight.getId());

        // Verify - flight availability should be updated
        assertFalse(isAvailable, "Flight should not be available after being booked.");
    }

    @Test
    public void testFlightAvailabilityAfterCancellation() {
        // Setup - create necessary instances
        FlightBooker flightBooker = new FlightBooker();
        Booking booking = new Booking(); // Assume this is an existing booking

        // Execute - cancel the booking and check availability
        flightBooker.cancelBooking(booking.getId());
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        boolean isAvailable = availabilityChecker.checkFlightAvailability(booking.getFlight().getId());

        // Verify - flight should be available after cancellation
        assertTrue(isAvailable, "Flight should be available after booking is cancelled.");
    }
}
