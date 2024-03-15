import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesIntegrationTest {

    @Test
    public void testTimeFormatConversion() {
        // Setup - create instances for testing conversion
        TimeFormatManager timeFormatManager = new TimeFormatManager();

        // Execute - convert time formats
        String convertedTime = timeFormatManager.convertTo12Hour("13:00");

        // Verify - check if the conversion is correct
        assertEquals("1:00 PM", convertedTime, "Time should be converted to 12-hour format correctly.");
    }

    @Test
    public void testDateValidation() {
        // Setup - create date utility instance
        Date dateUtil = new Date();

        // Execute - validate a date
        boolean isValid = dateUtil.validateDate("2024-03-15");

        // Verify - date should be valid
        assertTrue(isValid, "The date should be valid and not in the past.");
    }
}
