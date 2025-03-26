package com.carloslonghi.ScrumHub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tasks")
@Data // Cria os Getters e Setters
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status; // ToDo: usar ENUM para status da "task"

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne // Uma "tarefa" pode estar associada a apenas um "funcionário"
    @JoinColumn(name = "employee_id") // FK - Foreign Key
    private EmployeeModel employee;
}
