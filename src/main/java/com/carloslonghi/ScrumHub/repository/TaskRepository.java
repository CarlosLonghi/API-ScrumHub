package com.carloslonghi.ScrumHub.repository;

import com.carloslonghi.ScrumHub.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
