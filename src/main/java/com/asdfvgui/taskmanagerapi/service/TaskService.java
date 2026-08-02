package com.asdfvgui.taskmanagerapi.service;

import com.asdfvgui.taskmanagerapi.model.entity.Task;
import com.asdfvgui.taskmanagerapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(String title, String description) {

        Task task = new Task(title, description);

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow();

    }

    public Task updateTask(Long id, String title, String description) {

        Task task = taskRepository.findById(id)
                .orElseThrow();

        task.setTitle(title);
        task.setDescription(description);
        return taskRepository.save(task);
    }

    public Task deleteTask(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow();

        taskRepository.delete(task);

        return task;
    }
}
