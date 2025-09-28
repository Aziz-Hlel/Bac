package com.tigana.ClassUnit.DTO;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.OptionalSujectEnums;

import jakarta.annotation.Nullable;
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

    @Nullable    
    private MajorEnums principalMajorName;

    @Nullable
    private MajorEnums retakeMajorName;

    @Nullable
    private OptionalSujectEnums principalOptionalSubject; 

}
