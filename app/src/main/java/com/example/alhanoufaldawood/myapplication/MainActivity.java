package com.example.alhanoufaldawood.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText tasktitle;
    EditText taskdescription;
    EditText taskdeadline;
    Button addtask;

    DatabaseReference databaseTasks ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        databaseTasks = FirebaseDatabase.getInstance().getReference("tasks"); // i should pass the node name

        tasktitle = (EditText) findViewById(R.id.tasktitle);
        taskdescription = (EditText) findViewById(R.id.taskdescription);
        taskdeadline = (EditText) findViewById(R.id.taskdeadline);
        addtask = (Button) findViewById(R.id.addtask);



        addtask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    private void addTask (){

        String title = tasktitle.getText().toString().trim();
        String description = taskdescription.getText().toString().trim();
        String deadline = taskdeadline.getText().toString().trim();


        if (!TextUtils.isEmpty(title)) {

            String id = databaseTasks.push().getKey();

            Tasks task = new Tasks(id,title,description,deadline);

            databaseTasks.child(id).setValue(task);

            Toast.makeText(this,"Task added" ,Toast.LENGTH_LONG).show();


        } else{
            Toast.makeText(this,"Title is required" ,Toast.LENGTH_LONG).show();
        }

    }

}



