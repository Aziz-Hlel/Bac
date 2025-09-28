package com.tigana.ClassUnit.DTO;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkUpdateClassUnit {

    @NotNull
    private List<ClassUnitRequest> classUnits;

}
