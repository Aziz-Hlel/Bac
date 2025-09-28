package com.tigana.SchoolMajors.DTO;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkCreateSchoolMajorsRequest {

    @NotEmpty(message = "School majors list cannot be empty")
    @Size(max = 100, message = "Cannot process more than 100 items at once")
    @Valid
    @Builder.Default // Lombok’s @Builder.Default is needed to make sure this default value is used
                     // when using the builder pattern. Without it, the builder overrides your
                     // default with null.

    private final List<SchoolMajorsRequest> schoolMajors = new ArrayList<>();
    
}
