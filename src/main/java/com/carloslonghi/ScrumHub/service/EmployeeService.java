package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.model.EmployeeModel;
import com.carloslonghi.ScrumHub.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
