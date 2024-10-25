import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }
    
    // Add new tasks
    
    public void addTask(Task task) {
        if (taskMap.containsKey(task.gettaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.gettaskID(), task);
    }
    
    // Delete a task by ID
    
    public void deleteTask(String taskID) {
        if (!taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.remove(taskID);
    }
    
    // Update task name and description by ID
    
    public void updateTask(String taskID, String name, String description) {
        Task task = taskMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(name);
        task.setDescription(description);
    }
    public Task gettask(String taskID) {
    	return taskMap.get(taskID);
    }
}