package com.tigana.Exam.DTO;

import java.time.LocalDate;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.SessionEnums;
import com.tigana.Enums.SubjectEnums;
import com.tigana.Enums.TermEnums;

import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
public class UpdateExamRequest {

    @NonNull
    private final SubjectEnums subject;

    @NonNull
    private final MajorEnums major;

    @NonNull
    private final SessionEnums seesion;

    @NonNull
    private final float duration;

    @NonNull
    private final TermEnums term;

    @NonNull
    private final LocalDate date;
}
