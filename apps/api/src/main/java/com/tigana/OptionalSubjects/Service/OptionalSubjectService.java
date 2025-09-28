package com.tigana.OptionalSubjects.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.OptionalSubjects.DTO.OptionalSubjectRequest;
import com.tigana.OptionalSubjects.DTO.OptionalSubjectResponse;
import com.tigana.OptionalSubjects.DTO.UpdateOptionalSubject;
import com.tigana.OptionalSubjects.Mapper.OptionalSubjectMapper;
import com.tigana.OptionalSubjects.Model.OptionalSubject;
import com.tigana.OptionalSubjects.Repo.OptionalSubjectRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OptionalSubjectService {

    private final OptionalSubjectRepo optionalExamRepo;

    private final OptionalSubjectMapper optionalExamMapper;

    public UUID createOptionalExam(OptionalSubjectRequest optionalExam) {

        OptionalSubject newEntity = optionalExamMapper.toEntity(optionalExam);

        OptionalSubject savedEntity = optionalExamRepo.save(newEntity);

        return savedEntity.getId();
    }

    public OptionalSubjectResponse updateOptionalExam(UpdateOptionalSubject updateOptionalExam, UUID optionalExamId) {

        OptionalSubject optionalExam = optionalExamRepo.findById(optionalExamId)
                .orElseThrow(() -> new ResourceNotFoundException("Optional Exam doesn't exists"));

        OptionalSubject updatedEntity = optionalExamMapper.toUpdatedEntity(updateOptionalExam, optionalExam);

        OptionalSubject savedEntity = optionalExamRepo.save(updatedEntity);

        return optionalExamMapper.toDTO(savedEntity);

    }

    public OptionalSubjectResponse getOptionalExam(UUID optionalExamId) {

        OptionalSubject optionalExam = optionalExamRepo.findById(optionalExamId)
                .orElseThrow(() -> new ResourceNotFoundException("Optional Exam doesn't exists"));

        OptionalSubjectResponse dto = optionalExamMapper.toDTO(optionalExam);

        return dto;
    }

}
