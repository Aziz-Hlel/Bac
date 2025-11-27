package com.tigana.Teachers.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.tigana.School.Model.School;
import com.tigana.Teachers.DTO.TeacherRequest;
import com.tigana.Teachers.DTO.TeacherResponse;
import com.tigana.Teachers.Model.Teacher;
import com.tigana.Users.Model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TeacherMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "school", source = "school")
    @Mapping(target = "publicId", source = "teacherRequest.publicId")
    @Mapping(target = "user", source = "user")
    Teacher toEntity(TeacherRequest teacherRequest, School school, User user);

    @Mapping(target = "school", source = "teacher.school.name")
    TeacherResponse toDto(Teacher teacher);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "school", ignore = true)
    Teacher toUpdatedEntity(TeacherRequest teacherRequest, @MappingTarget Teacher teacher);
}
