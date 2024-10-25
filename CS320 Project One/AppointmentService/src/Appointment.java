import java.util.Date;

public class Appointment{
	private String appointmentId;
	private Date appointmentDate;
	private String description;
	
	//Constructor
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
		}
		this.appointmentId = appointmentId;
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
		}
		this.appointmentDate = appointmentDate;
		
		if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}
	//Getters
	public String getAppointmentId() {
        return appointmentId;
    }
	public Date getAppointmentDate() {
        return appointmentDate;
    }
	public String getDescription() {
        return description;
    }
}