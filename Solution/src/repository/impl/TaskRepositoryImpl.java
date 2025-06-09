package repository.impl;

import model.Task;
import repository.TaskRepository;

import java.util.*;

public class TaskRepositoryImpl implements TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();

    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public Task getTask(String id) {
        return tasks.get(id);
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void removeTask(String id) {
        tasks.remove(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}