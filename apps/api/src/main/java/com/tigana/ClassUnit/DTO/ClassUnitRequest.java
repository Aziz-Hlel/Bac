package com.tigana.ClassUnit.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassUnitRequest {

    @NotNull
    @NotEmpty
    private String name;

    // @Nullable
    // private MajorEnums principalMajorName;

    // @Nullable
    // private MajorEnums retakeMajorName;

    // @Nullable
    // private OptionalSujectEnums principalOptionalSubject;

}
