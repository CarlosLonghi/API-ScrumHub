package com.carloslonghi.ScrumHub.controller;

import com.carloslonghi.ScrumHub.dto.TaskDTO;
import com.carloslonghi.ScrumHub.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired // Injetando a dependencia service
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TaskDTO task) {
        TaskDTO taskCreated = taskService.createTask(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Tarefa \"" + taskCreated.getName() + "\" cadastrada com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        TaskDTO taskFound = taskService.getTaskById(id);
        if (taskFound != null) {
            return ResponseEntity.ok(taskFound);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Não existe tarefa com ID \"" + id + "\"");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody TaskDTO task) {
        TaskDTO taskFound = taskService.getTaskById(id);
        if (taskFound != null) {
            TaskDTO taskUpdated = taskService.updateTaskById(id, task);
            return ResponseEntity
                    .ok("Tarefa \"" + taskUpdated.getName() + "\" atualizada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não existe tarefa com ID \"" + id + "\"");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        TaskDTO taskFound = taskService.getTaskById(id);
        if (taskFound != null) {
            taskService.deleteTaskById(id);
            return ResponseEntity
                    .ok("Tarefa \"" + taskFound.getName() + "\" deletada com sucesso");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Não existe tarefa com ID \"" + id + "\"");
    }
}
