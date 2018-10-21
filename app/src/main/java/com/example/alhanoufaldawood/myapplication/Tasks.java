package com.example.alhanoufaldawood.myapplication;

import com.google.firebase.database.DatabaseReference;

public class Tasks {


    String taskId;
    String title;
    String description;
    String deadline;



   public Tasks() {

    }

    public Tasks(String taskId, String title, String description, String deadline) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }



}
