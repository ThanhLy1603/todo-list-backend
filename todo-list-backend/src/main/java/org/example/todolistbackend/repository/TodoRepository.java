package org.example.todolistbackend.repository;

import org.example.todolistbackend.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
    Page<Todo> findByTitleContainingAndStatusAndIsDeletedFalse(String title, String status, Pageable pageable);
    Page<Todo> findByTitleContainingAndIsDeletedFalse(String title, Pageable pageable);
    Optional<Todo> findByIdAndIsDeletedFalse(UUID id);
}
