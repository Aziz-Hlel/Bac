package com.tigana.SchoolMajors.DTO;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.TermEnums;

import lombok.Builder;

@Builder
public record SchoolMajorsResponse(MajorEnums majorName,TermEnums term, Integer classNumber) {

}
