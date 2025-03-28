package com.carloslonghi.ScrumHub.repository;

import com.carloslonghi.ScrumHub.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
