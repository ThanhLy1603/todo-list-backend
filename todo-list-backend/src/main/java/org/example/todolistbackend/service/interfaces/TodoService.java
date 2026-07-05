package org.example.todolistbackend.service.interfaces;

import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TodoService {
    public Page<Todo> findAllTodos(String search, String status, Pageable pageable);
    public Todo findTodoById(UUID id);
    public Todo createTodo(TodoRequest request);
    public Todo updateTodo(UUID id ,TodoRequest request);
    public ApiResponse deleteTodo(UUID id);
    public Todo toggleStatus(UUID id);
}
