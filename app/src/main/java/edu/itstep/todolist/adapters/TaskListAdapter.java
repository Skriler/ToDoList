package edu.itstep.todolist.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.itstep.todolist.R;
import edu.itstep.todolist.entities.Task;

public class TaskListAdapter extends ArrayAdapter<Task> {
    private final Context context;
    private final int resource;

    public TaskListAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task task = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView tvSubject = convertView.findViewById(R.id.tvSubject);
        TextView tvContent = convertView.findViewById(R.id.tvContent);
        TextView tvDate = convertView.findViewById(R.id.tvDate);

        tvSubject.setText(task.getSubject());
        tvContent.setText(task.getContent());
        tvDate.setText(task.getDate().toString());

        return convertView;
    }
}
