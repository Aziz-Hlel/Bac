package com.tigana.SchoolOptionalSubject.DTO;

import com.tigana.Enums.OptionalSujectEnums;
import com.tigana.Enums.TermEnums;

public record SchoolOptionalSubjectsResponse(OptionalSujectEnums optionalSubject, TermEnums term, int classNumber) {
}
