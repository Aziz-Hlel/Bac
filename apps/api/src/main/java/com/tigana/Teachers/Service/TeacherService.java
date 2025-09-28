package com.tigana.Teachers.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tigana.ErrorHandler.Exceptions.ForbiddenAccessException;
import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.School.Model.School;
import com.tigana.Teachers.DTO.TeacherRequest;
import com.tigana.Teachers.DTO.TeacherResponse;
import com.tigana.Teachers.Mapper.TeacherMapper;
import com.tigana.Teachers.Model.Teacher;
import com.tigana.Teachers.Repo.TeacherRepo;
import com.tigana.Users.Entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {

    @PersistenceContext
    private EntityManager entityManager;

    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;

    public UUID createTeacher(TeacherRequest teacherRequest, UUID userId) {

        School school = entityManager.getReference(School.class, teacherRequest.getSchoolId());
        User user = entityManager.getReference(User.class, userId);

        Teacher Entity = teacherMapper.toEntity(teacherRequest, school, user);
        Teacher teacher = teacherRepo.save(Entity);

        return teacher.getId();

    }

    public TeacherResponse updateTeacher(TeacherRequest teacherRequest, UUID teacherId, UUID userId) {

        Optional<Teacher> teacher = teacherRepo.findById(teacherId);

        if (teacher.isEmpty())
            throw new ResourceNotFoundException("Teacher doesn't exists");

        if (!teacher.get().getUser().getId().equals(userId))
            throw new ForbiddenAccessException("Teacher doesn't belongs to user");

        Teacher updatedEntity = teacherMapper.toUpdatedEntity(teacherRequest, teacher.get());

        Teacher entity = teacherRepo.save(updatedEntity);

        return teacherMapper.toDto(entity);
    }

    public TeacherResponse getTeacher(UUID teacherId, UUID userId) {

        Optional<Teacher> teacher = teacherRepo.findById(teacherId);

        if (teacher.isEmpty())
            throw new ResourceNotFoundException("Teacher doesn't exists");

        if (!teacher.get().getUser().getId().equals(userId))
            throw new ForbiddenAccessException("Teacher doesn't belongs to user");

        return teacherMapper.toDto(teacher.get());
    }

}
