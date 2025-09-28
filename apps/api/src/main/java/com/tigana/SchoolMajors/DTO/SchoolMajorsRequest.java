package com.tigana.SchoolMajors.DTO;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.TermEnums;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolMajorsRequest {

    @PositiveOrZero(message = "Class number must be greater than or equal to 0")
    @NotNull
    private final Integer classNumber;

    @NotNull
    private final MajorEnums majorName;

    @NotNull
    private final TermEnums term;


}
