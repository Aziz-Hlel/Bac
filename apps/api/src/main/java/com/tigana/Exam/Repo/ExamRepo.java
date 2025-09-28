package com.tigana.Exam.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tigana.Exam.Model.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, UUID> {
}
