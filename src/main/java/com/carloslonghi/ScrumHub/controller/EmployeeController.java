package com.carloslonghi.ScrumHub.controller;

import com.carloslonghi.ScrumHub.model.EmployeeModel;
import com.carloslonghi.ScrumHub.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getAll() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public String create() {
        return "Rota para criação de um funcionário";
    }

    @GetMapping("/{id}")
    public String getById() {
        return "Rota para busca de funcionário por id";
    }

    @PutMapping("/{id}")
    public String updateById() {
        return "Rota para alteração de funcionário por id";
    }

    @DeleteMapping("/{id}")
    public String deleteById() {
        return "Rota para deleção de funcionário por id";
    }
}
