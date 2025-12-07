package com.tigana.School.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.School.DTO.SchoolRequest;
import com.tigana.School.DTO.SchoolResponse;
import com.tigana.School.Service.SchoolService;
import com.tigana.Utils.UserContext;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Slf4j
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping({ "", "/" })
    public ResponseEntity<UUID> create(@Valid @RequestBody SchoolRequest schoolRequest) {


        UUID schoolId = schoolService.createSchool(schoolRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(schoolId);
    };

    @PutMapping("/{schoolId}")
    public ResponseEntity<SchoolResponse> put(@PathVariable UUID schoolId,
            @Valid @RequestBody SchoolRequest schoolRequest) {


        SchoolResponse entity = schoolService.updateSchool(schoolRequest, schoolId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolResponse> get(@PathVariable UUID schoolId) {

        String UserId = UserContext.getCurrentUserId();
        log.info("schoolId: {}", schoolId);
        SchoolResponse entity = schoolService.getSchool(schoolId, UserId);

        return ResponseEntity.ok(entity);
    }

}
