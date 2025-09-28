package com.tigana.Exam.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tigana.Exam.DTO.CreateExamRequest;
import com.tigana.Exam.DTO.ExamResponse;
import com.tigana.Exam.DTO.UpdateExamRequest;
import com.tigana.Exam.Mapper.ExamMapper;
import com.tigana.Exam.Model.Exam;
import com.tigana.Exam.Repo.ExamRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExamService {

    private final ExamRepo examRepo;
    private final ExamMapper examMapper;

    public UUID createExam(CreateExamRequest createExamRequest) {

        Exam exam = examMapper.toEntity(createExamRequest);

        Exam savedEntity = examRepo.save(exam);

        return savedEntity.getId();

    };

    public ExamResponse updateExam(UpdateExamRequest updateExamRequest, UUID examId) {

        Exam exam = examRepo.findById(examId)
                .orElseThrow(() -> new RuntimeException("exam not found"));

        examMapper.toUpdatedEntity(updateExamRequest, exam);

        return examMapper.toDTO(examRepo.save(exam));

    };

    public ExamResponse getExam(UUID id) {

        Exam exam = examRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("exam not found"));

        ExamResponse response = examMapper.toDTO(exam);

        return response;

    };

}
