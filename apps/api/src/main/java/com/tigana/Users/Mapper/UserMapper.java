package com.tigana.Users.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.tigana.Users.DTO.UserResponse;
import com.tigana.Users.Model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {



    @Mapping(source = "school.id", target = "schoolId")
    UserResponse toDto(User user);
}
