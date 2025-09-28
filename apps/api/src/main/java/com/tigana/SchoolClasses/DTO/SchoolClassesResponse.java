package com.tigana.SchoolClasses.DTO;

import java.util.List;

import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsResponse;

public record SchoolClassesResponse(List<SchoolMajorsResponse>  schoolMajors,
        List<SchoolOptionalSubjectsResponse> schoolOptionalSubjects) {

}
