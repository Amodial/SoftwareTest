import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID already exists.");
		}
		contacts.put(contact.getContactID(), contact); 
	}
	public void deleteContact(String contactID) {
		contacts.remove(contactID);
	}
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactID);
		if (contact!= null) {
			contact.setFirstName(firstName);
			contact.setFirstName(lastName);
			contact.setFirstName(phone);
			contact.setFirstName(address);
		}
	}
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
}