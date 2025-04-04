package com.carloslonghi.ScrumHub.controller;

import com.carloslonghi.ScrumHub.model.TaskModel;
import com.carloslonghi.ScrumHub.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired // Injetando a dependencia service
    private TaskService taskService;

    @GetMapping
    public List<TaskModel> getAll() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskModel create(@RequestBody TaskModel task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public TaskModel getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public String updateById() {
        return "Rota para alteração de tarefa por id";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
