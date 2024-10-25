import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("123", "Task Name", "Task Description");
        taskService.addTask(task);
        assertEquals(task, taskService.gettask("123"));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("123", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.gettask("123"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("123", "Old Name", "Old Description");
        taskService.addTask(task);
        taskService.updateTask("123", "New Name", "New Description");
        assertEquals("New Name", taskService.gettask("123").getname());
        assertEquals("New Description", taskService.gettask("123").getdescription());
    }

    @Test
    public void testAddTaskWithDuplicateIDThrowsException() {
        Task task1 = new Task("123", "Task1", "Description1");
        Task task2 = new Task("123", "Task2", "Description2");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void testDeleteNonExistentTaskThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("999"));
    }

    @Test
    public void testUpdateNonExistentTaskThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("999", "New Name", "New Description"));
    }
}