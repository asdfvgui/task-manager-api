package com.asdfvgui.taskmanagerapi.controller;


import com.asdfvgui.taskmanagerapi.dto.request.CreateTaskRequest;
import com.asdfvgui.taskmanagerapi.dto.response.TaskResponse;
import com.asdfvgui.taskmanagerapi.model.entity.Task;
import com.asdfvgui.taskmanagerapi.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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

    @GetMapping
    public List<TaskResponse> getAllTasks() {

        List<Task> tasks = taskService.getAllTasks();

        List<TaskResponse> taskResponses = new ArrayList<>();

        for (Task task : tasks){

            taskResponses.add(new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted()));

        }

        return taskResponses;

    }
}
