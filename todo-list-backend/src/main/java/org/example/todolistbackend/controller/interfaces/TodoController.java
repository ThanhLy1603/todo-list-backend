package org.example.todolistbackend.controller.interfaces;

import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TodoController<T> {
    public ResponseEntity<Page<T>> getAllTodos(String search, String status, int page, int size);
    public ResponseEntity<T> getTodoById(UUID id);
    public ResponseEntity<T> createTodo(TodoRequest todoRequest);
    public ResponseEntity<T> updateTodo(UUID id,TodoRequest todoRequest);
    public ResponseEntity<ApiResponse> deleteTodo(UUID id);
    public ResponseEntity<Todo> toggleStatus(UUID id);
}
