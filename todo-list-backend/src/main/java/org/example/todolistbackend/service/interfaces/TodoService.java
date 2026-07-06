package org.example.todolistbackend.service.interfaces;

import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.dto.response.TodoResponse;
import org.example.todolistbackend.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TodoService {
    public Page<TodoResponse> findAllTodos(String search, String status, Pageable pageable);
    public TodoResponse findTodoById(UUID id);
    public TodoResponse createTodo(TodoRequest request);
    public TodoResponse updateTodo(UUID id , TodoRequest request);
    public ApiResponse deleteTodo(UUID id);
    public TodoResponse toggleStatus(UUID id);
}
