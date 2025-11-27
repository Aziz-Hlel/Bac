package com.tigana.Exam.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.tigana.Exam.DTO.CreateExamRequest;
import com.tigana.Exam.DTO.ExamResponse;
import com.tigana.Exam.DTO.UpdateExamRequest;
import com.tigana.Exam.Model.Exam;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ExamMapper {

    @Mapping(target = "id", ignore = true)
    Exam toEntity(CreateExamRequest createExamRequest);

    @Mapping(target = "id", ignore = true)
    Exam toUpdatedEntity(UpdateExamRequest createExamRequest, @MappingTarget Exam exam);

    ExamResponse toDTO(Exam exam);

}
