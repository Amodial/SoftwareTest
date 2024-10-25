import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getfirstName());
        assertEquals("Doe", contact.getlastName());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Other tests for validation
}