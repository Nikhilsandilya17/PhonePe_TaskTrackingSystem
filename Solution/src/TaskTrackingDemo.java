import model.Task;
import model.Activity;
import service.TaskService;
import service.impl.TaskServiceImpl;

import java.util.List;

public class TaskTrackingDemo {
    public static void main(String[] args) {
        TaskService taskService = TaskServiceImpl.getInstance();

        taskService.addTask("Design Module", "Design the architecture");
        taskService.addTask("Implement Feature", "Develop the feature");

        List<Task> tasks = taskService.getAllTasks();
        String taskId = tasks.get(0).getId();

        taskService.modifyTask(taskId, "Design Module Updated", "Update the architecture design");
        taskService.completeTask(taskId);
        taskService.removeTask(taskId);

        System.out.println("All Tasks:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nActivity Log:");
        for (Activity activity : taskService.getActivityLog()) {
            System.out.println(activity);
        }
    }
}