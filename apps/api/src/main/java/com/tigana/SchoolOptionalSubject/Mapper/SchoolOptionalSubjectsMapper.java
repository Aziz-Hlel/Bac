package com.tigana.SchoolOptionalSubject.Mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsRequest;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsResponse;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjectsId;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SchoolOptionalSubjectsMapper {

    @Mapping(target = "schoolOptionalSubjectsId", expression = "java(toEmbeddedId(schoolOptionalSubjectsRequest, schoolId))")
    SchoolOptionalSubjects toEntity(SchoolOptionalSubjectsRequest schoolOptionalSubjectsRequest, UUID schoolId);

    @Mapping(target = "optionalSubject", source = "schoolOptionalSubjectsId.optionalSubject")
    @Mapping(target = "term", source = "schoolOptionalSubjectsId.term")
    SchoolOptionalSubjectsResponse toResponse(SchoolOptionalSubjects schoolOptionalSubjects);

    default SchoolOptionalSubjectsId toEmbeddedId(SchoolOptionalSubjectsRequest schoolOptionalSubjectsRequest,
            UUID schoolId) {
        return new SchoolOptionalSubjectsId(schoolId, schoolOptionalSubjectsRequest.getTerm(),
                schoolOptionalSubjectsRequest.getOptionalSubject());
    }

    default List<SchoolOptionalSubjects> toEntities(
            List<SchoolOptionalSubjectsRequest> schoolOptionalSubjectsRequests,
            UUID schoolId) {
        if (schoolOptionalSubjectsRequests == null)
            return null;
        return schoolOptionalSubjectsRequests.stream()
                .map(schoolOptionalSubjectsRequest -> toEntity(schoolOptionalSubjectsRequest, schoolId)).toList();
    }

    default List<SchoolOptionalSubjectsResponse> toResponses(List<SchoolOptionalSubjects> schoolOptionalSubjects) {
        if (schoolOptionalSubjects == null)
            return null;
        return schoolOptionalSubjects.stream().map(this::toResponse).toList();
    }
}
