package com.josueleando.todoapi.controllers;

import com.josueleando.todoapi.dtos.CreateTodoRequest;
import com.josueleando.todoapi.dtos.TodoDto;
import com.josueleando.todoapi.dtos.UpdateTodoRequest;
import com.josueleando.todoapi.mappers.TodoMapper;
import com.josueleando.todoapi.repositories.TodoRepository;
import com.josueleando.todoapi.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("todos")
public class TodoController {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final TodoMapper todoMapper;

    @GetMapping
    public Iterable<TodoDto> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(todoMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@Valid @RequestBody CreateTodoRequest request) {
        var user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("userId", "Responsável não encontrado"));
        }

        var todo = todoMapper.toEntity(request);
        todo.setResponsible(user);
        todo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoMapper.toDto(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTodoRequest request
    ) {
        var user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("userId", "Responsável não encontrado"));
        }

        return todoRepository.findById(id)
                .map(todo -> {
                    todoMapper.updateEntity(request, todo);
                    todo.setResponsible(user);
                    return todoRepository.save(todo);
                })
                .map(todoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if (!todoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
