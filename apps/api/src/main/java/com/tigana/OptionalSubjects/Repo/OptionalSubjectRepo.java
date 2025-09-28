package com.tigana.OptionalSubjects.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tigana.OptionalSubjects.Model.OptionalSubject;

@Repository
public interface OptionalSubjectRepo extends JpaRepository<OptionalSubject, UUID> {

}
