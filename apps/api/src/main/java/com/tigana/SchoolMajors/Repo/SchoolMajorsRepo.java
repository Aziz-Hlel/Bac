package com.tigana.SchoolMajors.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolMajors.Model.SchoolMajorsId;

public interface SchoolMajorsRepo extends JpaRepository<SchoolMajors, SchoolMajorsId> {

    // ✅ Correct: Navigate through the embeddedId
    List<SchoolMajors> findAllBySchoolMajorsId_schoolId(UUID schoolId);

}
