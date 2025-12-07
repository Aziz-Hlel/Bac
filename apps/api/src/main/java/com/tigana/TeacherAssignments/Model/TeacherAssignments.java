package com.tigana.TeacherAssignments.Model;

import com.tigana.Enums.AssignmentRole;
import com.tigana.ExamClasses.Model.ExamClasses;
import com.tigana.Teachers.Model.Teacher;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher_assignments", uniqueConstraints = {
        @UniqueConstraint(name = "uq_class_exam_schedule_role_teacher", columnNames = { "class_exam_schedule_id",
                "role", "teacher_id" })
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherAssignments {

    @EmbeddedId
    private TeacherAssignmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classExamScheduleId")
    @JoinColumn(name = "class_exam_schedule_id", nullable = false)
    private ExamClasses classExamSchedule;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private AssignmentRole role;

}
