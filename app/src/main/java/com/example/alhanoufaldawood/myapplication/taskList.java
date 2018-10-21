package com.example.alhanoufaldawood.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class taskList extends ArrayAdapter {

    private Activity context;
    private List<Tasks> taskList;

    public taskList(Activity context, List<Tasks> taskList) {

        super(context, R.layout.task_list, taskList);
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.task_list, null, true);

        TextView title = (TextView) listViewItem.findViewById(R.id.tasktitle);
        TextView deadline = (TextView) listViewItem.findViewById(R.id.taskdeadline);

        Tasks task = taskList.get(position);

        title.setText(task.getTitle());
        deadline.setText(task.getDeadline());

        return  listViewItem;





    }
}
