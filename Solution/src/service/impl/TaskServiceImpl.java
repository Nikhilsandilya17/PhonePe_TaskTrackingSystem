package service.impl;

import enums.TaskStatus;
import model.Activity;
import model.Task;
import repository.TaskRepository;
import repository.impl.TaskRepositoryImpl;
import service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static constants.ApplicationConstants.TASK_COMPLETED;
import static constants.ApplicationConstants.TASK_CREATED;
import static constants.ApplicationConstants.TASK_MODIFIED;
import static constants.ApplicationConstants.TASK_REMOVED;

public class TaskServiceImpl implements TaskService {
    private static TaskService taskService;
    private final TaskRepository taskRepository;
    private final List<Activity> activityLog;

    private TaskServiceImpl() {
        taskRepository = new TaskRepositoryImpl();
        activityLog = new ArrayList<>();
    }

    public static TaskService getInstance() {
        if (taskService == null) {
            taskService = new TaskServiceImpl();
        }
        return taskService;
    }

    @Override
    public void addTask(String taskName, String description) {
        Task task = new Task(generateId(), taskName, description);
        taskRepository.addTask(task);
        logActivity(task.getId(), TASK_CREATED);
    }


    @Override
    public void modifyTask(String id, String name, String description) {
        Task task = taskRepository.getTask(id);
        if (task != null) {
            task.setName(name);
            task.setDescription(description);
            taskRepository.updateTask(task);
            logActivity(id, TASK_MODIFIED);
        }
    }

    @Override
    public void completeTask(String id) {
        Task task = taskRepository.getTask(id);
        if (task != null) {
            task.setTaskStatus(TaskStatus.COMPLETED);
            taskRepository.updateTask(task);
            logActivity(id, TASK_COMPLETED);
        }
    }

    @Override
    public void removeTask(String id) {
        taskRepository.removeTask(id);
        logActivity(id, TASK_REMOVED);
    }

    @Override
    public List<Activity> getActivityLog() {
        return new ArrayList<>(activityLog);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    private void logActivity(String taskId, String action) {
        activityLog.add(new Activity(taskId, action));
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}