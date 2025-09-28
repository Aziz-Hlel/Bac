package com.tigana.OptionalSubjects.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.OptionalSubjects.DTO.OptionalSubjectRequest;
import com.tigana.OptionalSubjects.DTO.OptionalSubjectResponse;
import com.tigana.OptionalSubjects.DTO.UpdateOptionalSubject;
import com.tigana.OptionalSubjects.Service.OptionalSubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController()
@RequestMapping({ "/optional-exams", "/optional-exam" })
@RequiredArgsConstructor
public class OptionalSubjectController {

    private final OptionalSubjectService optionalExamService;

    @PostMapping({ "", "/" })
    public ResponseEntity<OptionalSubjectResponse> create(@RequestBody @Valid OptionalSubjectRequest createOptionalExam) {

        UUID optionalExamId = optionalExamService.createOptionalExam(createOptionalExam);

        OptionalSubjectResponse entity = optionalExamService.getOptionalExam(optionalExamId);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    };

    @PutMapping("/{optionalExamId}")
    public ResponseEntity<OptionalSubjectResponse> put(@PathVariable UUID optionalExamId,
            @RequestBody @Valid UpdateOptionalSubject updateOptionalExam) {

        OptionalSubjectResponse optionalExamResponse = optionalExamService.updateOptionalExam(updateOptionalExam,
                optionalExamId);

        return ResponseEntity.status(HttpStatus.OK).body(optionalExamResponse);

    }

    @GetMapping("/{optionalExamId}")
    public ResponseEntity<OptionalSubjectResponse> get(@PathVariable UUID optionalExamId) {

        OptionalSubjectResponse optionalExam = optionalExamService.getOptionalExam(optionalExamId);

        return ResponseEntity.ok(optionalExam);
    };

}
