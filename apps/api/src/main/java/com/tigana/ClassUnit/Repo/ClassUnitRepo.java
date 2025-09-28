package com.tigana.ClassUnit.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tigana.ClassUnit.Model.ClassUnit;
import com.tigana.School.Model.School;

@Repository
public interface ClassUnitRepo extends JpaRepository<ClassUnit, UUID> {

    List<ClassUnit> findAllBySchool(School school);

}
