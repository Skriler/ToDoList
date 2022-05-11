package edu.itstep.todolist.entities;

import java.util.Date;

public class Task {
    private String subject;
    private String content;
    private Date date;

    public Task(String subject, String content, Date date) {
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
