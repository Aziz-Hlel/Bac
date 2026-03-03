package com.tigana.ClassUnit.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.tigana.ClassUnit.DTO.ClassUnitRequest;
import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Model.ClassUnit;
import com.tigana.School.Model.School;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClassUnitMapper {

    ClassUnitResponse toResponse(ClassUnit entity);

    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "school", source = "school")
    ClassUnit toEntity(ClassUnitRequest request, School school);

    @Mapping(target = "name", source = "request.name")
    ClassUnit toUpdatedEntity(ClassUnit entity, ClassUnitRequest request);
}
