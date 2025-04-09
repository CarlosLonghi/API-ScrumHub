package com.carloslonghi.ScrumHub.controller;

import com.carloslonghi.ScrumHub.dto.TaskDTO;
import com.carloslonghi.ScrumHub.mapper.TaskMapper;
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
    public List<TaskDTO> getAll() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO updateById(@PathVariable Long id, @RequestBody TaskDTO task) {
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
