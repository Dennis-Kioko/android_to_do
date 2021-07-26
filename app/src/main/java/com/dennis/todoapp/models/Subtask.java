package com.dennis.todoapp.models;

public class Subtask {

    private int id;
    private String description;
    private boolean status;
    private int task_id;

    public Subtask(int id, String description, boolean status, int task_id) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.task_id = task_id;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
}
