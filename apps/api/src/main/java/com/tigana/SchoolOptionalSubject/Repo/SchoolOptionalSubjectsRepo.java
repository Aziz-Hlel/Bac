package com.tigana.SchoolOptionalSubject.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjectsId;

@Repository
public interface SchoolOptionalSubjectsRepo extends JpaRepository<SchoolOptionalSubjects, SchoolOptionalSubjectsId> {

    List<SchoolOptionalSubjects> findAllBySchoolOptionalSubjectsId_SchoolId(UUID schoolId);
}