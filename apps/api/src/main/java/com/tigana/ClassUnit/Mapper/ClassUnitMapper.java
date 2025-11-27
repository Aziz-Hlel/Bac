package com.tigana.ClassUnit.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Model.ClassUnit;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClassUnitMapper {

    ClassUnitResponse toResponse(ClassUnit entity);
}
