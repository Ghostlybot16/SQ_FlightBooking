package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class FlightTimeCalculatorTest {
    @Test
    void calculateTotalFlightTime_ShouldCalculateTime_WhenGivenFlights() {
        FlightTimeCalculator calculator = new FlightTimeCalculator();
        Duration totalDuration = calculator.calculateTotalFlightTime(mockFlightList());
        assertNotNull(totalDuration);
    }
}
