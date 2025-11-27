package com.tigana.OptionalSubjects.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.tigana.OptionalSubjects.DTO.OptionalSubjectRequest;
import com.tigana.OptionalSubjects.DTO.OptionalSubjectResponse;
import com.tigana.OptionalSubjects.DTO.UpdateOptionalSubject;
import com.tigana.OptionalSubjects.Model.OptionalSubject;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OptionalSubjectMapper {

    @Mapping(target = "id", ignore = true)
    OptionalSubject toEntity(OptionalSubjectRequest createOptionalExam);

    @Mapping(target = "id", ignore = true)
    OptionalSubject toUpdatedEntity(UpdateOptionalSubject updateOptionalExam,
            @MappingTarget OptionalSubject optionalExam);

    OptionalSubjectResponse toDTO(OptionalSubject optionalExam);
}
