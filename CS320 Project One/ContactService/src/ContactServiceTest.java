import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    // Tests for update functionality
}