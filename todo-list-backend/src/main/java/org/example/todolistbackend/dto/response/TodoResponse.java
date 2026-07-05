package org.example.todolistbackend.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TodoResponse {
    private UUID id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
