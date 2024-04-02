package QualityGroup.Flight_Booking_System;

import com.flightbooking.model.Booking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingTest {

    @Test
    void testId() {
        Booking booking = new Booking();
        Long id = 1L;
        booking.setId(id);
        assertEquals(id, booking.getId());
    }

    @Test
    void testFlightNumber() {
        Booking booking = new Booking();
        String flightNumber = "ABC123";
        booking.setFlightNumber(flightNumber);
        assertEquals(flightNumber, booking.getFlightNumber());

        assertThrows(NullPointerException.class, () -> booking.setFlightNumber(null));
    }

    @Test
    void testPassengerName() {
        Booking booking = new Booking();
        String passengerName = "John Doe";
        booking.setPassengerName(passengerName);
        assertEquals(passengerName, booking.getPassengerName());

        assertThrows(NullPointerException.class, () -> booking.setPassengerName(null));
    }

    @Test
    void testBookingTime() {
        Booking booking = new Booking();
        LocalDateTime bookingTime = LocalDateTime.now();
        booking.setBookingTime(bookingTime);
        assertEquals(bookingTime, booking.getBookingTime());

        assertNotNull(booking.getBookingTime());
    }
}