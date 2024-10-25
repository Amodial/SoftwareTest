public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	//Constructor with limitation of max 10 characters
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		if (phone == null || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		if (address == null || address.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	// Getters
	public String getContactID() {
		return contactID;
	}
	public String getfirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public String getphone() {
		return phone;
	}
	public String getaddress() {
		return address;
	}
	
	//Setters with limitations in mind
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		this.phone = phone;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 10) {
			throw new IllegalArgumentException("Invalid address.");
		}
		this.address = address;
	}
}