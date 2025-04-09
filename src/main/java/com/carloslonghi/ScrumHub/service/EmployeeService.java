package com.carloslonghi.ScrumHub.service;

import com.carloslonghi.ScrumHub.dto.EmployeeDTO;
import com.carloslonghi.ScrumHub.mapper.EmployeeMapper;
import com.carloslonghi.ScrumHub.model.EmployeeModel;
import com.carloslonghi.ScrumHub.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeModel> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::map)
                .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employee = employeeMapper.map(employeeDTO);
        employee = employeeRepository.save(employee);
        return employeeMapper.map(employee);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        return employee.map(employeeMapper::map).orElse(null);
    }

    public EmployeeDTO updateById(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeModel> employeeExist = employeeRepository.findById(id);
        if (employeeExist.isPresent()) {
            EmployeeModel employeeUpdated = employeeMapper.map(employeeDTO);
            employeeUpdated.setId(id);
            EmployeeModel employee = employeeRepository.save(employeeUpdated);
            return employeeMapper.map(employee);
        }
        return null;
    }

    public void deleteEmployeeById(Long id) {
        Optional<EmployeeModel> employeeExist = employeeRepository.findById(id);
        if (employeeExist.isPresent()) {
            employeeRepository.deleteById(id);
        }
    }
}
