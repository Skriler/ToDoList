package edu.itstep.todolist.services;

import java.util.ArrayList;
import java.util.Date;

import edu.itstep.todolist.entities.Task;

public class TaskService {
    public static ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task("subject1", "content1", new Date()));
        tasks.add(new Task("subject2", "content2", new Date()));
        tasks.add(new Task("subject3", "content3", new Date()));
        tasks.add(new Task("subject4", "content4", new Date()));
        tasks.add(new Task("subject5", "content5", new Date()));
        tasks.add(new Task("subject6", "content6", new Date()));
        tasks.add(new Task("subject7", "content7", new Date()));

        return tasks;
    }
}
