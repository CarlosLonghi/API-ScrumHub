package com.carloslonghi.ScrumHub.controller;

import com.carloslonghi.ScrumHub.dto.EmployeeDTO;
import com.carloslonghi.ScrumHub.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmployeeDTO employee) {
        EmployeeDTO employeeCreated = employeeService.createEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Funcionário \"" + employeeCreated.getName() + "\" cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        if (employeeFound != null) {
            return ResponseEntity.ok(employeeFound);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Não existe funcionário com ID \"" + id + "\"");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        if (employeeFound != null) {
            EmployeeDTO employeeUpdated = employeeService.updateById(id, employee);
            return ResponseEntity
                    .ok("Funcionário \"" + employeeUpdated.getName() + "\" atualizado com sucesso");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Não existe funcionário com ID \"" + id + "\"");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        if (employeeFound != null) {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity
                    .ok("Funcionário \"" + employeeFound.getName() + "\" deletado com sucesso");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Não existe funcionário com ID \"" + id + "\"");
    }
}
