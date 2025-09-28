package com.tigana.SchoolMajors.DTO;

import java.util.List;

import lombok.Builder;

@Builder
public record BulkSchoolMajorsResponse(List<SchoolMajorsResponse> schoolMajors) {

}
