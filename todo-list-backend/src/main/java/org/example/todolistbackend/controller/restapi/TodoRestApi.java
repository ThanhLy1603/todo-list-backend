package org.example.todolistbackend.controller.restapi;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolistbackend.controller.interfaces.TodoController;
import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.dto.response.TodoResponse;
import org.example.todolistbackend.service.interfaces.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoRestApi implements TodoController<TodoResponse> {
    private final TodoService todoService;

    @Override
    @GetMapping("")
    public ResponseEntity<Page<TodoResponse>> getAllTodos(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<TodoResponse> todos = todoService.findAllTodos(search, status, pageable);

        return ResponseEntity.ok(todos);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoRequest todoRequest) {
        return ResponseEntity.ok(todoService.createTodo(todoRequest));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable UUID id,@Valid @RequestBody TodoRequest todoRequest) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoRequest));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTodo(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @Override
    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<TodoResponse> toggleStatus(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.toggleStatus(id));
    }
}
