package com.prem.taskmanager.repository;

import com.prem.taskmanager.entity.Task;
import com.prem.taskmanager.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndStatus(Long userId, TaskStatus status);
    Optional<Task> findByIdAndUserId(Long id, Long userId);
}
