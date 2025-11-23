package com.tigana.School.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.tigana.School.DTO.SchoolRequest;
import com.tigana.School.DTO.SchoolResponse;
import com.tigana.School.Model.School;
import com.tigana.Users.Model.User;


@Mapper(componentModel = "spring")
public interface SchoolMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    School toEntity(SchoolRequest schoolRequest,User user);

    SchoolResponse toDto(School school);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    School toUpdatedEntity(SchoolRequest schoolRequest,@MappingTarget School school);
}
