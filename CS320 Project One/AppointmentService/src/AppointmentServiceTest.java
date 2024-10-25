import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description");
        appointmentService.addAppointment(appointment);

        assertTrue(appointmentService.getAppointments().containsKey("1234567890"));
    }

    @Test
    public void testAddDuplicateAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment1 = new Appointment("1234567890", futureDate, "Valid description");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Another description");
        appointmentService.addAppointment(appointment1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description");
        appointmentService.addAppointment(appointment);

        appointmentService.deleteAppointment("1234567890");

        assertFalse(appointmentService.getAppointments().containsKey("1234567890"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistent");
        });
    }
}