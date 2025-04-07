package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.model.EmployeeModel;
import com.carloslonghi.ScrumHub.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel createEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeModel getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public EmployeeModel updateById(Long id, EmployeeModel employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
