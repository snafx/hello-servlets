package com.sda.todo;

import java.time.LocalDate;

public class TodoModel {

    private String name;
    private String description;
    private boolean checked;
    private int priority;
    private LocalDate date;

    public TodoModel() {
    }

    public TodoModel(String name, String description, boolean checked, int priority, LocalDate date) {
        this.name = name;
        this.description = description;
        this.checked = checked;
        this.priority = priority;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
