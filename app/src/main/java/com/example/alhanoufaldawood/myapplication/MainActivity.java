package com.example.alhanoufaldawood.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    EditText taskTitle;
    EditText taskDescription;
    EditText txtDate, txtTime;

    Button addTask;
    Button btnDatePicker, btnTimePicker;


    DatabaseReference databaseTasks ;


    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        databaseTasks = FirebaseDatabase.getInstance().getReference("tasks"); // i should pass the node name

        taskTitle = (EditText) findViewById(R.id.tasktitle);
        taskDescription = (EditText) findViewById(R.id.taskdescription);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);

        addTask = (Button) findViewById(R.id.addtask);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectDeadline(v);

                }

                                             });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectDeadline(v);

            }
        });



        addTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addTask();
                Intent AddTask = new Intent(MainActivity.this, TasksList.class);
                startActivity(AddTask);
            }
        });
    }

    private void addTask (){

        String title = taskTitle.getText().toString().trim();
        String description = taskDescription.getText().toString().trim();
        String time =txtTime.getText().toString().trim();
        String date =txtDate.getText().toString().trim();


        if (!TextUtils.isEmpty(title)) {

            String id = databaseTasks.push().getKey();

            Tasks task = new Tasks(id,title,description,date ,time);

            databaseTasks.child(id).setValue(task);

            Toast.makeText(this,"Task added" ,Toast.LENGTH_LONG).show();


        } else{
            Toast.makeText(this,"Title is required" ,Toast.LENGTH_LONG).show();
        }


    }

    public void selectDeadline(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

}



