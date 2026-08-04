package com.asdfvgui.taskmanagerapi.controller;


import com.asdfvgui.taskmanagerapi.dto.request.CreateTaskRequest;
import com.asdfvgui.taskmanagerapi.dto.response.TaskResponse;
import com.asdfvgui.taskmanagerapi.model.entity.Task;
import com.asdfvgui.taskmanagerapi.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {

        this.taskService = taskService;

    }


    @PostMapping
    public TaskResponse createTask(@RequestBody CreateTaskRequest request) {
        Task task = taskService.createTask(request.getTitle(), request.getDescription());
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted());
    }
}
