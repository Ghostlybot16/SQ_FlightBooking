import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightSearchIntegrationTest {

    @Test
    public void testSearchAndSelectFlight() {
        // Setup - create a flight search instance
        FlightSearch flightSearch = new FlightSearch();
        AvailableFlights availableFlights = new AvailableFlights();

        // Execute - perform a search and select a flight
        List<Flight> flights = flightSearch.search("NYC", "LAX", "2024-03-15", "2024-03-20", TripType.ONE_WAY);
        Flight selectedFlight = flights.get(0); // Assume the first flight is selected
        availableFlights.selectFlight(selectedFlight.getId());

        // Verify - selected flight should match the one searched for
        assertEquals(selectedFlight.getId(), availableFlights.getSelectedFlightId(), "Selected flight ID should match the searched flight.");
    }

    @Test
    public void testSearchWithUserPreferences() {
        // Setup - create a flight search instance and user preferences
        FlightSearch flightSearch = new FlightSearch();
        UserPreferenceService userPreferenceService = new UserPreferenceService();
        userPreferenceService.setTimeFormatPreference(TimeFormat.TWELVE_HOUR);

        // Execute - perform a search considering user preferences
        List<Flight> flights = flightSearch.search("NYC", "LAX", "2024-03-15", "2024-03-20", TripType.ROUND_TRIP);

        // Verify - assert that flights adhere to user preferences (mock or stub as needed)
        assertTrue(flights.stream().allMatch(f -> f.getTimeFormat().equals(TimeFormat.TWELVE_HOUR)), "All flights should be in the user's preferred time format.");
    }
}
