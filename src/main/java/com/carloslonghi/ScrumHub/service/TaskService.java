package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.model.TaskModel;
import com.carloslonghi.ScrumHub.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public TaskModel createTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel getTaskById(Long id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public TaskModel updateTaskById(Long id, TaskModel task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
