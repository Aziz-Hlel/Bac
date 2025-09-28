package com.tigana.OptionalSubjects.DTO;

import java.time.LocalDate;
import java.util.UUID;

import com.tigana.Enums.OptionalSujectEnums;
import com.tigana.Enums.TermEnums;

public record OptionalSubjectResponse(
        UUID id,
        OptionalSujectEnums subject,
        Float duration,
        TermEnums term,
        LocalDate date) {
}
