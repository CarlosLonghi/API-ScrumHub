package com.carloslonghi.ScrumHub.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @GetMapping
    public String getAll() {
        return "Rota para listar todas as tarefas";
    }

    @PostMapping
    public String create() {
        return "Rota para criação de uma tarefa";
    }

    @GetMapping("/{id}")
    public String getById() {
        return "Rota para busca de tarefa por id";
    }

    @PutMapping("/{id}")
    public String updateById() {
        return "Rota para alteração de tarefa por id";
    }

    @DeleteMapping("/{id}")
    public String deleteById() {
        return "Rota para deleção de tarefa por id";
    }
}
