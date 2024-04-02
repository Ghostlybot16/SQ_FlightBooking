package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class WeeklyFlightsTest {
    @Test
    void addFlight_ShouldIncreaseListSize_WhenNewFlightIsAdded() {
        WeeklyFlights weeklyFlights = new WeeklyFlights();
        int initialSize = weeklyFlights.getFlights().size();
        weeklyFlights.addFlight(new Flight(...));
        assertEquals(initialSize + 1, weeklyFlights.getFlights().size());
    }
}
