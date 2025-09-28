package com.tigana.SchoolClasses.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.SchoolClasses.DTO.SchoolClassesRequest;
import com.tigana.SchoolClasses.DTO.SchoolClassesResponse;
import com.tigana.SchoolClasses.Service.SchoolClassesService;
import com.tigana.Utils.AppConstants;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/schools/{schoolId}/school-classes") // ! you dont get the schoolId from the url you get it from the
                                                      // token, this is just to make the url more readable and maybe for
                                                      // the super admin later on
@RequiredArgsConstructor
public class SchoolClassesController {

    private final SchoolClassesService schoolClassesService;

    @PostMapping({ "/", "" })
    public ResponseEntity<Boolean> createSchoolClasses(@RequestBody @Valid SchoolClassesRequest request) {

        UUID schoolId = AppConstants.schoolId;

        schoolClassesService.createSchoolClasses(request, schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(true);

    }

    @PutMapping({ "/", "" })
    public ResponseEntity<Boolean> updateSchoolClasses(@RequestBody @Valid SchoolClassesRequest request) {

        UUID schoolId = AppConstants.schoolId;

        schoolClassesService.updatedSchoolClasses(request, schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(true);

    };

    @GetMapping({ "/", "" })
    public ResponseEntity<SchoolClassesResponse> getSchoolClasses() {

        UUID schoolId = AppConstants.schoolId;

        SchoolClassesResponse response = schoolClassesService.getSchoolClasses(schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    };

}
