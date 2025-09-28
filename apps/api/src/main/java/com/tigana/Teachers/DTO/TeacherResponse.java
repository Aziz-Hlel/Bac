package com.tigana.Teachers.DTO;

import com.tigana.Enums.SubjectEnums;

public record TeacherResponse(
        String publicId,
        String prefix,
        String firstName,
        String lastName,
        Boolean isTeacher,
        SubjectEnums subject,
        String school) {

}
