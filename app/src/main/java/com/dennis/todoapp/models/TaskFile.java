package com.dennis.todoapp.models;

public class TaskFile {

    private int id;
    private String file_url;
    private int task_id;

    public TaskFile(int id, String file_url, int task_id) {
        this.id = id;
        this.file_url = file_url;
        this.task_id = task_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
}
