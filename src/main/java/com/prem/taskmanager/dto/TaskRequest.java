package com.prem.taskmanager.dto;

import com.prem.taskmanager.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private TaskStatus status;
}
