package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.dto.TaskDTO;
import com.carloslonghi.ScrumHub.mapper.TaskMapper;
import com.carloslonghi.ScrumHub.model.TaskModel;
import com.carloslonghi.ScrumHub.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> getAllTasks() {
        List<TaskModel> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        TaskModel task = taskMapper.map(taskDTO);
        task = taskRepository.save(task);
        return taskMapper.map(task);
    }

    public TaskDTO getTaskById(Long id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.map(taskMapper::map).orElse(null);
    }

    public TaskDTO updateTaskById(Long id, TaskDTO taskDTO) {
        Optional<TaskModel> taskExist = taskRepository.findById(id);
        if (taskExist.isPresent()) {
            TaskModel taskUpdated = taskMapper.map(taskDTO);
            taskUpdated.setId(id);
            TaskModel task = taskRepository.save(taskUpdated);
            return taskMapper.map(task);
        }
        return null;
    }

    public void deleteTaskById(Long id) {
        Optional<TaskModel> taskExist = taskRepository.findById(id);
        if (taskExist.isPresent()) {
            taskRepository.deleteById(id);
        }
    }
}
