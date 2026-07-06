package org.example.todolistbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.todolistbackend.entity.Todo;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TodoResponse {
    private UUID id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }
}
