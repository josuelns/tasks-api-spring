package com.josueleando.todoapi.mappers;

import com.josueleando.todoapi.dtos.CreateUserRequest;
import com.josueleando.todoapi.dtos.UpdateUserRequest;
import com.josueleando.todoapi.dtos.UserDto;
import com.josueleando.todoapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(CreateUserRequest request);

    void updateEntity(UpdateUserRequest request, @MappingTarget User user);
}
