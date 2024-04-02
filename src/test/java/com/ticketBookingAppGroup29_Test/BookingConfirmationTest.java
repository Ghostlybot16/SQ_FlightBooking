package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class BookingConfirmationTest {
    @Test
    void displayConfirmation_ShouldShowDetails_WhenBookingIsConfirmed() {
        BookingConfirmation confirmation = new BookingConfirmation();
        confirmation.displayConfirmation(mockBookingDetails());
        assertTrue(confirmation.isDisplayed());
    }
}
