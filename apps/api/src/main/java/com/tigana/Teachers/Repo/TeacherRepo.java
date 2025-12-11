package com.tigana.Teachers.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tigana.Teachers.Model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, UUID> , JpaSpecificationExecutor<Teacher>{

    @Query("SELECT t FROM Teacher t WHERE t.school.user.id = :userId")
    List<Teacher> findAllByUserId(@Param("userId") String userId);

    // List<Teacher> findBySchoolUserId(String userId); // * save as the above
    // method , but JPA will automatically generate the query for you

}
