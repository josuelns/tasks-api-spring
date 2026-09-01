package com.josueleando.todoapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoRequest {

    @NotBlank(message = "Título é obrigatório")
    @Size(min = 2, max = 255, message = "Título deve ter entre 2 e 255 caracteres")
    private String title;

    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    private String description;

    private boolean completed;

    @NotNull(message = "Responsável é obrigatório")
    private Long userId;
}
