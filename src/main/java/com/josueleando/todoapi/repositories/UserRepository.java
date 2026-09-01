package com.josueleando.todoapi.repositories;

import com.josueleando.todoapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
