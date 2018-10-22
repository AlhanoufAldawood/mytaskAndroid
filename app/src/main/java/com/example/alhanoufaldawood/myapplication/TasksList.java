package com.example.alhanoufaldawood.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TasksList extends AppCompatActivity {

    ListView listViewTasks;
    DatabaseReference ref;
    List<Tasks> TasksList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);


        TasksList = new ArrayList<>();
        listViewTasks = (ListView) findViewById(R.id.listViewID);
        ref= FirebaseDatabase.getInstance().getReference("tasks");



    }

    @Override
    protected void onStart() {
        super.onStart();


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                TasksList.clear();

                for (DataSnapshot childSnapShot :dataSnapshot.getChildren()){

                    Tasks task=childSnapShot.getValue(Tasks.class);

                    TasksList.add(task);

                }

                TaskList adapter = new TaskList(TasksList.this , TasksList);

                listViewTasks.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}