package com.asdfvgui.taskmanagerapi.repository;

import com.asdfvgui.taskmanagerapi.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
