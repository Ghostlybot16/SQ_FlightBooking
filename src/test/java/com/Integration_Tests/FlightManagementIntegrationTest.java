import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightManagementIntegrationTest {

    @Test
    public void testFlightSchedulingAndBooking() {
        // Setup - create flight and booking instances
        WeeklyFlights weeklyFlights = new WeeklyFlights();
        FlightBooker flightBooker = new FlightBooker();
        Flight flight = new Flight(); // Mock a new flight

        // Execute - add flight to schedule and book it
        weeklyFlights.addFlight(flight);
        UserDetails userDetails = new UserDetails(); // Mock user details
        Booking booking = flightBooker.bookDirectFlight(flight.getId(), userDetails);

        // Verify - ensure the flight can be booked
        assertNotNull(booking, "Flight should be successfully booked after being scheduled.");
    }

    @Test
    public void testFlightCancellationAndAvailability() {
        // Setup - create necessary objects and data
        FlightBooker flightBooker = new FlightBooker();
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        Booking booking = new Booking(); // Assume this is an existing booking
        Flight flight = booking.getFlight(); // Get the booked flight

        // Execute - cancel the booking and check availability
        flightBooker.cancelBooking(booking.getId());
        boolean isAvailable = availabilityChecker.checkFlightAvailability(flight.getId());

        // Verify - flight should be available after cancellation
        assertTrue(isAvailable, "Flight should be available after booking cancellation.");
    }
}
