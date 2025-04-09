package com.carloslonghi.ScrumHub.dto;

import com.carloslonghi.ScrumHub.model.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private String status;
    private LocalDate endDate;
    private EmployeeModel employee;
}
