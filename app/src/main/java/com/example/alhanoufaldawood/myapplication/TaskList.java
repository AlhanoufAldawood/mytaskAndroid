package com.example.alhanoufaldawood.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskList extends ArrayAdapter<Tasks> {



    private Activity context;
    private List<Tasks> taskList;

    public TaskList( Activity context, List<Tasks> taskList) {

        super(context, R.layout.child_list, taskList);

        this.context = context;
        this.taskList = taskList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.child_list, null, false);



        TextView name = (TextView) listViewItem.findViewById(R.id.nameText);

        Tasks task = taskList.get(position);

       name.setText(task.getTitle());

        return listViewItem;

    }
}
