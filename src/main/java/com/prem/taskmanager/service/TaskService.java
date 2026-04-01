package com.prem.taskmanager.service;

import com.prem.taskmanager.dto.TaskRequest;
import com.prem.taskmanager.dto.TaskResponse;
import com.prem.taskmanager.entity.Task;
import com.prem.taskmanager.entity.TaskStatus;
import com.prem.taskmanager.entity.User;
import com.prem.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskResponse createTask(TaskRequest request, User user) {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus() != null ? request.getStatus() : TaskStatus.TODO)
                .user(user)
                .build();

        return mapToResponse(taskRepository.save(task));
    }
    // Get all tasks for logged-in user
    public List<TaskResponse> getAllTasks(User user) {
        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get tasks by status
    public List<TaskResponse> getTasksByStatus(User user, TaskStatus status) {
        return taskRepository.findByUserIdAndStatus(user.getId(), status)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get single task
    public TaskResponse getTaskById(Long taskId, User user) {
        Task task = taskRepository.findByIdAndUserId(taskId, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return mapToResponse(task);
    }

    // Update task
    public TaskResponse updateTask(Long taskId, TaskRequest request, User user) {
        Task task = taskRepository.findByIdAndUserId(taskId, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        if (request.getStatus() != null) task.setStatus(request.getStatus());

        return mapToResponse(taskRepository.save(task));
    }

    // Delete task
    public void deleteTask(Long taskId, User user) {
        Task task = taskRepository.findByIdAndUserId(taskId, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }

    // Map Entity → DTO
    private TaskResponse mapToResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}

