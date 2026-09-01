package com.josueleando.todoapi.mappers;

import com.josueleando.todoapi.dtos.CreateTodoRequest;
import com.josueleando.todoapi.dtos.TodoDto;
import com.josueleando.todoapi.dtos.UpdateTodoRequest;
import com.josueleando.todoapi.entities.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TodoMapper {
    TodoDto toDto(Todo todo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "responsible", ignore = true)
    Todo toEntity(CreateTodoRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "responsible", ignore = true)
    void updateEntity(UpdateTodoRequest request, @MappingTarget Todo todo);
}
