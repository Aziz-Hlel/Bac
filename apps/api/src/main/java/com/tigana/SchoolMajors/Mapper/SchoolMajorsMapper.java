package com.tigana.SchoolMajors.Mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.tigana.SchoolMajors.DTO.SchoolMajorsRequest;
import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolMajors.Model.SchoolMajorsId;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SchoolMajorsMapper {

    @Mapping(target = "schoolMajorsId", expression = "java(toEmbeddedId(schoolMajorsRequest, schoolId))")
    SchoolMajors toEntity(SchoolMajorsRequest schoolMajorsRequest, UUID schoolId);

    @Mapping(target = "majorName", source = "schoolMajorsId.majorName")
    @Mapping(target = "term", source = "schoolMajorsId.term")
    SchoolMajorsResponse toResponse(SchoolMajors schoolMajors);

    default SchoolMajorsId toEmbeddedId(SchoolMajorsRequest schoolMajorsRequest, UUID schoolId) {
        return new SchoolMajorsId(schoolId, schoolMajorsRequest.getTerm(), schoolMajorsRequest.getMajorName());
    }

    default List<SchoolMajors> toEntities(List<SchoolMajorsRequest> schoolMajorsRequests, UUID schoolId) {
        if (schoolMajorsRequests == null)
            return null;

        return schoolMajorsRequests.stream()
                .map(schoolMajorsRequest -> toEntity(schoolMajorsRequest, schoolId))
                .toList();
    }

    default List<SchoolMajorsResponse> toResponses(List<SchoolMajors> schoolMajors) {
        if (schoolMajors == null)
            return null;
        return schoolMajors.stream()
                .map(this::toResponse)
                .toList();
    }
}
