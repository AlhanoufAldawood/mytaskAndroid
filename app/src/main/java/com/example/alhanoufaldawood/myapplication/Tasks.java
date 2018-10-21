package com.example.alhanoufaldawood.myapplication;

import com.google.firebase.database.DatabaseReference;

public class Tasks {


    String taskId;
    String title;
    String description;
    String date;
    String time;




   public Tasks() {

    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Tasks(String taskId, String title, String description, String date, String time) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;

    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }



    public String getDescription() {
        return description;
    }



}
