package org.example.todolistbackend.repository;

import org.example.todolistbackend.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
    Page<Todo> findByTitleContainingAndStatus(String title, String status, Pageable pageable);
    Page<Todo> findByTitleContaining(String title, Pageable pageable);
}
