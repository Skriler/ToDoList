package edu.itstep.todolist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import edu.itstep.todolist.R;
import edu.itstep.todolist.adapters.TaskListAdapter;
import edu.itstep.todolist.entities.Task;
import edu.itstep.todolist.services.TaskService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TASK_LIST_TAG = "tasks";

    ArrayList<Task> tasks;
    ListView lvTasks;
    TaskListAdapter adapterTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = TaskService.getTasks();
        adapterTask = new TaskListAdapter(this, R.layout.custom_list_view_item, tasks);
        lvTasks = findViewById(R.id.lvTasks);
        lvTasks.setAdapter(adapterTask);

        (findViewById(R.id.btnAdd)).setOnClickListener(this);
        (findViewById(R.id.btnDelete)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnAdd):
                addTask();
                break;
            case (R.id.btnDelete):
                deleteSelectedTasks();
                break;
        }
    }

    private void addTask() {
        String subject = ((EditText)findViewById(R.id.etSubject)).getText().toString();
        String content = ((EditText)findViewById(R.id.etContent)).getText().toString();

        if (subject.equals("") || content.equals(""))
            return;

        Task newTask = new Task(subject, content, new Date());
        adapterTask.add(newTask);

        ((EditText)findViewById(R.id.etSubject)).setText("");
        ((EditText)findViewById(R.id.etContent)).setText("");
    }

    private void deleteSelectedTasks() {
        int startPos = lvTasks.getFirstVisiblePosition();
        int endPos = lvTasks.getLastVisiblePosition();

        for (int i = endPos - startPos; i >= 0 ; i--) {
            View elementView = lvTasks.getChildAt(i);

            if (elementView == null)
                continue;

            CheckBox checkBox = elementView.findViewById(R.id.checkBox);
            if (checkBox.isChecked()){
                Task task = adapterTask.getItem(i + startPos);
                adapterTask.remove(task);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(TASK_LIST_TAG, tasks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tasks = (ArrayList<Task>) savedInstanceState.getSerializable(TASK_LIST_TAG);
        adapterTask = new TaskListAdapter(this, R.layout.custom_list_view_item, tasks);
        lvTasks = findViewById(R.id.lvTasks);
        lvTasks.setAdapter(adapterTask);
    }
}