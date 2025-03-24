package com.carloslonghi.ScrumHub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

    @GetMapping("/api/v1/employee")
    public String hello() {
        return "Você acessou a rota de funcionários";
    }

}
