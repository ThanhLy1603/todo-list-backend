package org.example.todolistbackend.test;

import lombok.RequiredArgsConstructor;
import org.example.todolistbackend.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Test implements CommandLineRunner {
    private final TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!todoRepository.findAll().isEmpty()) {
            System.out.println(todoRepository.findAll());
        }

    }
}
