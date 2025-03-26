package com.carloslonghi.ScrumHub.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

// @Entity do JPA (Java Persistence API) transforma uma classe comum em uma entidade do Banco de Dados
@Entity
@Table(name = "tb_employees")
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
    private List<TaskModel> tasks;

    public EmployeeModel() {
    }

    public EmployeeModel(String name, short age, String email, String role, LocalDate hireDate, int rank) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
        this.hireDate = hireDate;
        this.rank = rank;
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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getHire_date() {
        return hireDate;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hireDate = hire_date;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
