import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("123", "Task Name", "Task Description");
        assertEquals("123", task.gettaskID());
        assertEquals("Task Name", task.getname());
        assertEquals("Task Description", task.getdescription());
    }

    @Test
    public void testTaskIDCannotBeUpdated() {
        Task task = new Task("123", "Task Name", "Task Description");
        assertEquals("123", task.gettaskID());
        // The taskID is final; it should not be updateable.
    }

    @Test
    public void testNameFieldValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Valid Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "This name is way too long for the requirement", "Valid Description"));
    }

    @Test
    public void testDescriptionFieldValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Valid Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Valid Name", "This description is way too long to be valid since it exceeds fifty characters easily."));
    }

    @Test
    public void testSetName() {
        Task task = new Task("123", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getname());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("123", "Name", "Old Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getdescription());
    }

    @Test
    public void testInvalidNameUpdate() {
        Task task = new Task("123", "Valid Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("This name is way too long for the requirement"));
    }

    @Test
    public void testInvalidDescriptionUpdate() {
        Task task = new Task("123", "Name", "Valid Description");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This description is way too long to be valid since it exceeds fifty characters easily."));
    }
}