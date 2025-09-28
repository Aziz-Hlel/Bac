package com.tigana.SchoolOptionalSubject.DTO;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BulkCreateSchoolOptionalSubjectsRequest {

    @Builder.Default 
    @NotEmpty(message = "School optional subjects list cannot be empty")
    @Size(max = 20, message = "Cannot process more than 100 items at once")
    private final List<SchoolOptionalSubjectsRequest> schoolOptionalSubjects = new ArrayList<>();

}
