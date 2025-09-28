package com.tigana.School.Repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigana.School.Model.School;

public interface SchoolRepo extends JpaRepository<School, UUID> {


    Optional<School> findByPublicId(String publicId);
    
    Optional<School> findByUserIdAndPublicId(UUID userId, String publicId);

}
