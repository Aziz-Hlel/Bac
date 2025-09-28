package com.tigana.ClassUnit.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Model.ClassUnit;

@Mapper(componentModel = "spring")
public interface ClassUnitMapper {

    @Mapping(target = "principalMajorName", source = "schoolMajorsPrincipal.schoolMajorsId.majorName")
    @Mapping(target = "retakeMajorName", source = "schoolMajorsRetake.schoolMajorsId.majorName")
    @Mapping(target = "principalOptionalSubject", source = "schoolOptionalSubjectsPrincipal.schoolOptionalSubjectsId.optionalSubject")
    ClassUnitResponse toResponse(ClassUnit entity);
}
