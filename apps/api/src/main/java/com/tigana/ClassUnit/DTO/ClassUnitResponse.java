package com.tigana.ClassUnit.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassUnitResponse {

    @NotNull
    @NotEmpty
    private String name;

}
