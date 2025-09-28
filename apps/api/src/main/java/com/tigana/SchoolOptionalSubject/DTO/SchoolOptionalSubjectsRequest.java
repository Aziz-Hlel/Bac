package com.tigana.SchoolOptionalSubject.DTO;

import com.tigana.Enums.OptionalSujectEnums;
import com.tigana.Enums.TermEnums;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SchoolOptionalSubjectsRequest {

    @NotNull
    private OptionalSujectEnums optionalSubject;

    @NotNull
    private TermEnums term;

    @NotNull
    private int classNumber;
}
