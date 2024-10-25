import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {
	
	@Test
	public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description");
        
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Valid description", appointment.getDescription());
	}
    @Test
    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Valid description"); // ID too long
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000); // past date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Valid description");
        });
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This description is way too long to be valid since it exceeds fifty characters.");
        });

    }
}