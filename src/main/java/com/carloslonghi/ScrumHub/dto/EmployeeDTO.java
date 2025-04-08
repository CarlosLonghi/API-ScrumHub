package com.carloslonghi.ScrumHub.dto;

import com.carloslonghi.ScrumHub.model.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private short age;
    private String email;
    private String phone;
    private String role;
    private LocalDate hireDate;
    private int rank;
    private List<TaskModel> tasks;
}
