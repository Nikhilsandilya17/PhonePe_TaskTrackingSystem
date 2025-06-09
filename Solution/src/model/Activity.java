package model;

import java.util.Date;

public class Activity {
    private Date date;
    private String taskId;
    private String action;

    public Activity(String taskId, String action) {
        this.taskId = taskId;
        this.action = action;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "date=" + date +
                ", taskId='" + taskId + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}