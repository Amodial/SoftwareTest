import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    // In-memory data structure to store appointments
    private Map<String, Appointment> appointments = new HashMap<>();

    // Method to add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }

    // Getter for the appointments map (optional, for testing)
    public Map<String, Appointment> getAppointments() {
        return appointments;
    }
}