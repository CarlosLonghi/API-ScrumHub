package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.model.TaskModel;
import com.carloslonghi.ScrumHub.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }
}
