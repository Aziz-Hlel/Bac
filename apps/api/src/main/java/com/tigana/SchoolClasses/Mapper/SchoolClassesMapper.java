package com.tigana.SchoolClasses.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tigana.SchoolClasses.DTO.SchoolClassesResponse;
import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsResponse;

@Mapper(componentModel = "spring")
public interface SchoolClassesMapper {

    SchoolClassesResponse toResponse(List<SchoolMajorsResponse> schoolMajors,
            List<SchoolOptionalSubjectsResponse> schoolOptionalSubjects);
}
