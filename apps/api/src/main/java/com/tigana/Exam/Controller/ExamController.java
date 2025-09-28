package com.tigana.Exam.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.tigana.Exam.DTO.CreateExamRequest;
import com.tigana.Exam.DTO.ExamResponse;
import com.tigana.Exam.DTO.UpdateExamRequest;
import com.tigana.Exam.Service.ExamService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping({"/exam","/exams"})
@AllArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping({ "", "/" })
    public ResponseEntity<UUID> post(@RequestBody @Valid CreateExamRequest createExamRequest) {

        UUID ExamId = examService.createExam(createExamRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ExamId);
    };

    @PutMapping("/{examId}")
    public ResponseEntity<ExamResponse> put(@PathVariable UUID examId,
            @RequestBody @Valid UpdateExamRequest updateExamRequest) {

        ExamResponse updatedEntity = examService.updateExam(updateExamRequest, examId);

        return ResponseEntity.ok(updatedEntity);

    };

    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponse> get(@PathVariable UUID examId) {

        ExamResponse entity = examService.getExam(examId);

        return ResponseEntity.ok(entity);

    };

}
