package com.tigana.Teachers.DTO;

import com.tigana.Enums.SubjectEnums;

public record TeacherResponse(
                String id,
                String publicId,
                String prefix,
                String firstName,
                String lastName,
                Boolean isTeacher,
                SubjectEnums subject,
                String school) {

}
