package QualityGroup.Flight_Booking_System;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class FlightBookingApplicationTest {

    @Test
    public void testContextLoads() {
    }

    @Test
    public void testSomeComponentMethod() {
        SomeComponent someComponent = new SomeComponent();
        String result = someComponent.someMethod();
        assertEquals("Expected result", result);
}
}

