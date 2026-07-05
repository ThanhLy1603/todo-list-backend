package org.example.todolistbackend.controller.restapi;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolistbackend.controller.interfaces.TodoController;
import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.entity.Todo;
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
public class TodoRestApi implements TodoController<Todo> {
    private final TodoService todoService;

    @Override
    @GetMapping("")
    public ResponseEntity<Page<Todo>> getAllTodos(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Todo> todos = todoService.findAllTodos(search, status, pageable);

        return ResponseEntity.ok(todos);
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody TodoRequest todoRequest) {
        return ResponseEntity.ok(todoService.createTodo(todoRequest));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable UUID id,@Valid @RequestBody TodoRequest todoRequest) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoRequest));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTodo(UUID id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @Override
    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<Todo> toggleStatus(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.toggleStatus(id));
    }
}
