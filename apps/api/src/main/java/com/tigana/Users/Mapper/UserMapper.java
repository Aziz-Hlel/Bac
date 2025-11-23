package com.tigana.Users.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tigana.Users.DTO.UserRequest;
import com.tigana.Users.Model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", constant = "ADMIN")
    @Mapping(target = "school", ignore = true)
    User toEntity(UserRequest userRequest);

}
