package com.carloslonghi.ScrumHub.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tasks")
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

    // Uma "tarefa" pode estar associada a apenas um "funcionário"
    @ManyToOne
    @JoinColumn(name = "employee_id") // FK - Foreign Key
    private EmployeeModel employee;

    public TaskModel() {
    }

    public TaskModel(String name, String description, String status, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
