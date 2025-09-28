package com.tigana.Exam.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.SessionEnums;
import com.tigana.Enums.SubjectEnums;
import com.tigana.Enums.TermEnums;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateExamRequest {

    @NotNull
    private final SubjectEnums subject;

    @NotNull
    private final MajorEnums major;

    @NotNull
    private final SessionEnums seesion;

    @NotNull
    private final float duration;

    @NotNull
    private final TermEnums term;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Exam date cannot be in the past")
    private final LocalDate date;
}
