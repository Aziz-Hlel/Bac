package com.tigana.ClassUnit.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.ClassUnit.DTO.BulkUpdateClassUnit;
import com.tigana.ClassUnit.DTO.ClassUnitRequest;
import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Service.ClassUnitService;
import com.tigana.Utils.AppConstants;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("schools/{schoolId}/class-units")
@RequiredArgsConstructor
public class ClassUnitController {

    private ClassUnitService classUnitService;

    @PostMapping({ "", "/" })
    public ResponseEntity<Boolean> create(@RequestBody @Valid ClassUnitRequest request) {

        UUID schoolId = AppConstants.schoolId;
        String userId = AppConstants.userId;

        classUnitService.createClassUnit(request, userId, schoolId);

        return ResponseEntity.status(HttpStatus.CREATED).body(true);

    }

    @PutMapping("/{classUnitId}")
    public ResponseEntity<Boolean> put(@PathVariable UUID id, @RequestBody @Valid ClassUnitRequest request) {

        UUID schoolId = AppConstants.schoolId;
        String userId = AppConstants.userId;

        classUnitService.createClassUnit(request, userId, schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(true);

    };

    @PutMapping("")
    public ResponseEntity<Boolean> putMethodName(@RequestBody @Valid BulkUpdateClassUnit request) {

        UUID schoolId = AppConstants.schoolId;
        String userId = AppConstants.userId;

        classUnitService.bulkUpdateClassUnitByMajorsAndTerms(request, userId, schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(true);

    }

    @GetMapping("/{classUnitId}")
    public ResponseEntity<ClassUnitResponse> get(@PathVariable UUID classUnitId) {

        String userId = AppConstants.userId;
        ClassUnitResponse response = classUnitService.getClassUnit(classUnitId, userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<ClassUnitResponse>> get() {

        String userId = AppConstants.userId;
        UUID schoolId = AppConstants.schoolId;
        List<ClassUnitResponse> response = classUnitService.bulkGetClassUnit(schoolId, userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    };

}
