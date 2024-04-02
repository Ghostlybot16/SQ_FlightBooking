package com.ticketBookingAppGroup29_Test;
import org.junit.Test;
import com.ticketBookingAppGroup29.*;

public class TimeFormatTest {
    @Test
    void convertTimeFormat_ShouldConvert_WhenGivenTimeAndFormat() {
        TimeFormat timeFormat = new TimeFormat();
        String convertedTime = timeFormat.convertTimeFormat("14:00", TimeFormatPreference.TWELVE_HOUR);
        assertEquals("2:00 PM", convertedTime);
    }
}
