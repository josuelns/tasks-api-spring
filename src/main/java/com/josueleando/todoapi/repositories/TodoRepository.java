package com.josueleando.todoapi.repositories;

import com.josueleando.todoapi.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
