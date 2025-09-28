package com.tigana.SchoolMajors.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.SchoolMajors.DTO.BulkCreateSchoolMajorsRequest;
import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolMajors.Service.SchoolMajorsService;
import com.tigana.Utils.AppConstants;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/schools/{schoolId}/school-majors") // ! you dont get the schoolId from the url you get it from the
                                                     // token, this is just to make the url more readable and maybe for
                                                     // the super admin later on
@RequiredArgsConstructor
public class SchoolMajorsController {

    private final SchoolMajorsService schoolMajorsService;

    @PostMapping("/")
    public ResponseEntity<String> createSchoolMajors(@Valid @RequestBody BulkCreateSchoolMajorsRequest request) {

        UUID schoolId = AppConstants.schoolId;

        List<SchoolMajors> entity = schoolMajorsService.createSchoolMajors(request.getSchoolMajors(), schoolId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(String.valueOf(entity));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateSchoolMajors(@Valid @RequestBody BulkCreateSchoolMajorsRequest response) {

        UUID schoolId = AppConstants.schoolId;

        List<SchoolMajors> entity = schoolMajorsService.updatedSchoolMajors(response.getSchoolMajors(), schoolId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(String.valueOf(entity));

    }

    @GetMapping("/")
    public ResponseEntity<List<SchoolMajorsResponse>> getSchoolMajors(@PathVariable UUID schoolId) {

        List<SchoolMajorsResponse> entity = schoolMajorsService.getSchoolMajors(schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(entity);

    }

}
