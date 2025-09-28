package com.tigana.OptionalSubjects.DTO;

import java.time.LocalDate;

import com.tigana.Enums.OptionalSujectEnums;
import com.tigana.Enums.TermEnums;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOptionalSubject {

    @NotNull
    private final OptionalSujectEnums subject;

    @NotNull
    @DecimalMin(value = "1", inclusive = true, message = "Duration must be greater or equal to 1 hour")
    private final Float duration;

    @NotNull
    private final TermEnums term;

    @NotNull
    private final LocalDate date;
}
