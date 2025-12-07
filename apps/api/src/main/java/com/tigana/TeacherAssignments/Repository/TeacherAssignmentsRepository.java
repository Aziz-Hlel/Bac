package com.tigana.TeacherAssignments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigana.TeacherAssignments.Model.TeacherAssignmentId;
import com.tigana.TeacherAssignments.Model.TeacherAssignments;

public interface TeacherAssignmentsRepository  extends JpaRepository<TeacherAssignments, TeacherAssignmentId> {

}
