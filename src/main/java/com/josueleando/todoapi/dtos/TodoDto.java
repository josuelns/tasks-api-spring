package com.josueleando.todoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private UserDto responsible;
}
