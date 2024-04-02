package com.ticketBookingAppGroup29_Test;
import com.ticketBookingAppGroup29.*;
import org.junit.Test;

public class BookingFormTest {
    @Test
    void collectUserInfo_ShouldCollectUserInformation_WhenInvoked() {
        BookingForm bookingForm = new BookingForm();
        UserDetails userDetails = bookingForm.collectUserInfo();
        assertNotNull(userDetails);
    }

    @Test
    void submitBooking_ShouldSubmitBooking_WhenGivenUserInfoAndFlightDetails() {
        BookingForm bookingForm = new BookingForm();
        BookingDetails bookingDetails = bookingForm.submitBooking(mockUserDetails(), mockFlightDetails());
        assertNotNull(bookingDetails);
    }
}
