package com.carloslonghi.ScrumHub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// @Entity do JPA (Java Persistence API) transforma uma classe comum em uma entidade do Banco de Dados
@Entity
@Table(name = "tb_employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short age;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    private int rank;

    // Um "funcionário" poderá estar associado a várias "tarefas"
    @OneToMany(mappedBy = "employee")
    @JsonIgnore // Evita erro de serialização (loop infinino)
    private List<TaskModel> tasks;
}
