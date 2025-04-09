package com.carloslonghi.ScrumHub.mapper;

import com.carloslonghi.ScrumHub.dto.EmployeeDTO;
import com.carloslonghi.ScrumHub.model.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeModel map(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeDTO.getId());
        employeeModel.setName(employeeDTO.getName());
        employeeModel.setAge(employeeDTO.getAge());
        employeeModel.setEmail(employeeDTO.getEmail());
        employeeModel.setPhone(employeeDTO.getPhone());
        employeeModel.setRole(employeeDTO.getRole());
        employeeModel.setHireDate(employeeDTO.getHireDate());
        employeeModel.setRank(employeeDTO.getRank());
        employeeModel.setTasks(employeeDTO.getTasks());

        return employeeModel;
    }

    public EmployeeDTO map(EmployeeModel employeeModel) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeModel.getId());
        employeeDTO.setName(employeeModel.getName());
        employeeDTO.setAge(employeeModel.getAge());
        employeeDTO.setEmail(employeeModel.getEmail());
        employeeDTO.setPhone(employeeModel.getPhone());
        employeeDTO.setRole(employeeModel.getRole());
        employeeDTO.setHireDate(employeeModel.getHireDate());
        employeeDTO.setRank(employeeModel.getRank());
        employeeDTO.setTasks(employeeModel.getTasks());

        return employeeDTO;
    }
}
