package org.example.todolistbackend.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.todolistbackend.dto.request.TodoRequest;
import org.example.todolistbackend.dto.response.ApiResponse;
import org.example.todolistbackend.entity.Todo;
import org.example.todolistbackend.exception.ResourceNotFoundException;
import org.example.todolistbackend.repository.TodoRepository;
import org.example.todolistbackend.service.interfaces.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public Page<Todo> findAllTodos(String search, String status, Pageable pageable) {
        String keyword = (search == null) ? "" : search.trim().toLowerCase();

        if (status != null && !status.trim().isEmpty()) {
            return todoRepository.findByTitleContainingAndStatus(keyword, status, pageable);
        }

        return todoRepository.findByTitleContaining(keyword, pageable);
    }

    @Override
    public Todo findTodoById(UUID id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy công việc id: " + id));
    }

    @Override
    @Transactional
    public Todo createTodo(TodoRequest request) {
        Todo todo = new Todo();

        String status = request.getStatus();
        if (status != null && !status.isBlank()) {
            String upperStatus = status.toUpperCase();

            if (!upperStatus.equals("PENDING") &&  !upperStatus.equals("COMPLETED")) {
                throw new IllegalArgumentException("Trạng thái không hợp lệ");
            }

            todo.setStatus(upperStatus);
        } else {
            todo.setStatus("PENDING");
        }

        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setCreateAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());

        System.out.println("todo: " + todo.toString());

        return todoRepository.save(todo);
    }

    @Override
    @Transactional
    public Todo updateTodo(UUID id, TodoRequest request) {
        Todo todo = findTodoById(id);
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());

        if (request.getStatus() != null) {
            String upperStatus = request.getStatus().toUpperCase();
            todo.setStatus(upperStatus);
        }

        todo.setUpdatedAt(LocalDateTime.now());

        System.out.println("todo: " + todo.toString());

        return todoRepository.save(todo);
    }

    @Override
    @Transactional
    public ApiResponse deleteTodo(UUID id) {
        Todo todo = findTodoById(id);
        todoRepository.delete(todo);

        return new ApiResponse("Xóa thành công", true);
    }

    @Override
    public Todo toggleStatus(UUID id) {
        Todo todo = findTodoById(id);

        String currentStatus = todo.getStatus();

        String newStatus = "COMPLETED".equals(currentStatus) ? "PENDING" : "COMPLETED";
        todo.setStatus(newStatus);
        todo.setUpdatedAt(LocalDateTime.now());

        return todoRepository.save(todo);
    }
}
