package com.tigana.School.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.ErrorHandler.Exceptions.ForbiddenAccessException;
import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.School.DTO.SchoolRequest;
import com.tigana.School.DTO.SchoolResponse;
import com.tigana.School.Mapper.SchoolMapper;
import com.tigana.School.Model.School;
import com.tigana.School.Repo.SchoolRepo;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class SchoolService {

  private SchoolRepo schoolRepo;
  private SchoolMapper schoolMapper;
  private UsersRepo usersRepo;

  public UUID createSchool(SchoolRequest schoolRequest, String userId) {

    User user = usersRepo.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    // ! i think it needs more conditions like even if a user already has a school
    // it need to throw an erro , or a public id with that same school exist too
    Optional<School> school = schoolRepo.findByUserIdAndPublicId(user.getId(), schoolRequest.getPublicId());
    if (school.isPresent())
      throw new ResourceNotFoundException("School already exists");

    School entity = schoolMapper.toEntity(schoolRequest, user);
    entity = schoolRepo.save(entity);

    user.setSchool(entity);
    usersRepo.save(user);

    return entity.getId();
  }

  public SchoolResponse updateSchool(SchoolRequest schoolRequest, UUID schoolId, String userId) {

    School school = schoolRepo.findById(schoolId)
        .orElseThrow(() -> new ResourceNotFoundException("School doesn't exists"));

    if (!school.getUser().getId().equals(userId))
      throw new ForbiddenAccessException("School doesn't belongs to user");

    School updatedEntity = schoolMapper.toUpdatedEntity(schoolRequest, school);

    School entity = schoolRepo.save(updatedEntity);

    return schoolMapper.toDto(entity);

  }

  public SchoolResponse getSchool(UUID schoolId, String userId) {

    School school = schoolRepo.findById(schoolId)
        .orElseThrow(() -> new ResourceNotFoundException("School doesn't exists"));

    if (!school.getUser().getId().equals(userId)) // ! or user roles != Super Admin
      throw new ForbiddenAccessException("School doesn't belongs to user");

    return schoolMapper.toDto(school);
  }

  public School getSchoolEntity(UUID schoolId, String userId) {
    School school = schoolRepo.findById(schoolId)
        .orElseThrow(() -> new ResourceNotFoundException("School doesn't exists"));

    return school;
  }

}
