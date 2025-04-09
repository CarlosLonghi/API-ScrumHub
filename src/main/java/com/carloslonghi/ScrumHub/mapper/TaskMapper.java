package com.carloslonghi.ScrumHub.mapper;

import com.carloslonghi.ScrumHub.dto.TaskDTO;
import com.carloslonghi.ScrumHub.model.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel map(TaskDTO taskDTO) {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(taskDTO.getId());
        taskModel.setName(taskDTO.getName());
        taskModel.setDescription(taskDTO.getDescription());
        taskModel.setStatus(taskDTO.getStatus());
        taskModel.setEndDate(taskDTO.getEndDate());
        taskModel.setEmployee(taskDTO.getEmployee());

        return taskModel;
    }

    public TaskDTO map(TaskModel taskModel) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(taskModel.getId());
        taskDTO.setName(taskModel.getName());
        taskDTO.setDescription(taskModel.getDescription());
        taskDTO.setStatus(taskModel.getStatus());
        taskDTO.setEndDate(taskModel.getEndDate());
        taskDTO.setEmployee(taskModel.getEmployee());

        return taskDTO;
    }
}
