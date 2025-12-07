package com.tigana.TeacherAssignments.Model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class TeacherAssignmentId implements Serializable {

    @Column(name = "teacher_id", nullable = false)
    private UUID teacherId;

    @Column(name = "class_exam_schedule_id", nullable = false)
    private UUID classExamScheduleId;

}
