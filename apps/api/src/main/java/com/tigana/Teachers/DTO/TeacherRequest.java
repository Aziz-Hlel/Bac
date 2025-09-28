package com.tigana.Teachers.DTO;

import java.util.UUID;

import com.tigana.Enums.PrefixEnum;
import com.tigana.Enums.SubjectEnums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherRequest {

    private String publicId;
    
    @NotNull
    private PrefixEnum prefix;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Boolean isTeacher;

    private SubjectEnums subject;

    @NotNull
    private UUID schoolId;

}
