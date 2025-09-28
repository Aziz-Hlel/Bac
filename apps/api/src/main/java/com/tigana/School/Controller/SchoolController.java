package com.tigana.School.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.School.DTO.SchoolRequest;
import com.tigana.School.DTO.SchoolResponse;
import com.tigana.School.Service.SchoolService;
import com.tigana.Utils.UserContext;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
@Slf4j

public class SchoolController {

    private SchoolService schoolService;

    @PostMapping({ "", "/" })
    public ResponseEntity<UUID> create(@Valid @RequestBody SchoolRequest schoolRequest) {

        UUID UserId = UserContext.getCurrentUserId();

        UUID schoolId = schoolService.createSchool(schoolRequest, UserId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(schoolId);
    };

    @PutMapping("/{schoolId}")
    public ResponseEntity<SchoolResponse> put(@PathVariable UUID schoolId,
            @Valid @RequestBody SchoolRequest schoolRequest) {

        UUID UserId = UserContext.getCurrentUserId();

        SchoolResponse entity = schoolService.updateSchool(schoolRequest, schoolId, UserId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolResponse> get(@PathVariable UUID schoolId) {

        UUID UserId = UserContext.getCurrentUserId();
        log.info("schoolId: {}", schoolId);
        SchoolResponse entity = schoolService.getSchool(schoolId, UserId);

        return ResponseEntity.ok(entity);
    }

}
