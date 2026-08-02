package com.asdfvgui.taskmanagerapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed = false;


    // Protected constructor required by JPA/Hibernate.
    // Used by the framework to instantiate the entity when loading data from the database.
    protected Task() {
    }


    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean isCompleted() {
        return completed;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }
}
