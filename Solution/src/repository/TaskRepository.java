package repository;

import model.Task;
import java.util.List;

public interface TaskRepository {
    void addTask(Task task);
    Task getTask(String id);
    void updateTask(Task task);
    void removeTask(String id);
    List<Task> getAllTasks();
}