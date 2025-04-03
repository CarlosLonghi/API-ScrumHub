package com.carloslonghi.ScrumHub.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping
    public String getAll() {
        return "Rota para listar todos os funcionários";
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
