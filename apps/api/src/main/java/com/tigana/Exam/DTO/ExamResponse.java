package com.tigana.Exam.DTO;

import java.time.LocalDate;
import java.util.UUID;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.SessionEnums;
import com.tigana.Enums.SubjectEnums;
import com.tigana.Enums.TermEnums;

public record ExamResponse(
        UUID id,
        MajorEnums major,
        SubjectEnums subject,
        SessionEnums session,
        float duration,
        TermEnums term,
        LocalDate date) {
}
