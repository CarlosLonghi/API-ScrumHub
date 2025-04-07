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
    public EmployeeModel create(@RequestBody EmployeeModel employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeModel getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeModel updateById(@PathVariable Long id, @RequestBody EmployeeModel employee) {
        return employeeService.updateById(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
