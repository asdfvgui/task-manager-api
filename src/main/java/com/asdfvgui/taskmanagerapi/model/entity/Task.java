package com.asdfvgui.taskmanagerapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed = false;


    // Protected constructor required by JPA/Hibernate.
    // Used by the framework to instantiate the entity when loading data from the database.
    protected Task() {
    }


    public Task(String title, String description) {
        updateTitle(title);
        updateDescription(description);
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


    public void updateTitle(String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        this.title = title.trim();

    }

    public void updateDescription(String description) {
        this.description = description == null
                ? ""
                : description.trim();
    }


    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }
}
