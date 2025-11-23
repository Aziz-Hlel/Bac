package com.tigana.ClassUnit.Mapper;

import org.mapstruct.Mapper;

import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Model.ClassUnit;

@Mapper(componentModel = "spring")
public interface ClassUnitMapper {

    ClassUnitResponse toResponse(ClassUnit entity);
}
