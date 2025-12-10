package com.tigana.SchoolClasses.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.firebase.internal.FirebaseService;
import com.tigana.SchoolClasses.DTO.SchoolClassesRequest;
import com.tigana.SchoolClasses.DTO.SchoolClassesResponse;
import com.tigana.SchoolClasses.Mapper.SchoolClassesMapper;
import com.tigana.SchoolMajors.DTO.SchoolMajorsRequest;
import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolMajors.Service.SchoolMajorsService;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsRequest;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsResponse;
import com.tigana.SchoolOptionalSubject.Service.SchoolOptionalSubjectsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassesService {

    private final SchoolMajorsService schoolMajorsService;
    private final SchoolOptionalSubjectsService schoolOptionalSubjectsService;

    private final SchoolClassesMapper schoolClassesMapper;

    public void createSchoolClasses(SchoolClassesRequest request, UUID schoolId) {

        List<SchoolMajorsRequest> schoolMajors = request.getSchoolMajors();
        List<SchoolOptionalSubjectsRequest> schoolOptionalSubjects = request.getSchoolOptionalSubjects();

        schoolMajorsService.createSchoolMajors(schoolMajors, schoolId);
        schoolOptionalSubjectsService.createSchoolOptionalSubjects(schoolOptionalSubjects, schoolId);

    };

    public void updatedSchoolClasses(SchoolClassesRequest request, UUID schoolId) {
        List<SchoolMajorsRequest> schoolMajors = request.getSchoolMajors();
        List<SchoolOptionalSubjectsRequest> schoolOptionalSubjects = request.getSchoolOptionalSubjects();

        schoolMajorsService.updatedSchoolMajors(schoolMajors, schoolId);
        schoolOptionalSubjectsService.updatedSchoolOptionalSubjects(schoolOptionalSubjects, schoolId);
    };

    public SchoolClassesResponse getSchoolClasses(UUID schoolId) {
        List<SchoolMajorsResponse> schoolMajors = schoolMajorsService.getSchoolMajors(schoolId);
        List<SchoolOptionalSubjectsResponse> schoolOptionalSubjects = schoolOptionalSubjectsService
                .getSchoolOptionalSubjects(schoolId);

        SchoolClassesResponse response = schoolClassesMapper.toResponse(schoolMajors, schoolOptionalSubjects);

        return response;
    };

};
