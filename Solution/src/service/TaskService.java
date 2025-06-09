package service;

import model.Activity;
import model.Task;

import java.util.List;

public interface TaskService {
    void addTask(String taskName, String description);

    void modifyTask(String id, String name, String description);

    void completeTask(String id);

    void removeTask(String id);

    List<Activity> getActivityLog();

    List<Task> getAllTasks();
}