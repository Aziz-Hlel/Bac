package com.tigana.School.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.ErrorHandler.Exceptions.ForbiddenAccessException;
import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.School.DTO.SchoolRequest;
import com.tigana.School.DTO.SchoolResponse;
import com.tigana.School.Mapper.SchoolMapper;
import com.tigana.School.Model.School;
import com.tigana.School.Repo.SchoolRepo;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;
import com.tigana.Utils.AuthenticationUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class SchoolService {

  private SchoolRepo schoolRepo;
  private SchoolMapper schoolMapper;
  private UsersRepo usersRepo;

  private final FirebaseAuthService firebaseService;

  public UUID createSchool(SchoolRequest schoolRequest) {

    String userId = AuthenticationUtils.getCurrentUserId();

    User user = usersRepo.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    School userSchool = user.getSchool();
    if (userSchool != null) {
      throw new ForbiddenAccessException("User already has a school assigned");
    }

    // it need to throw an erro , or a public id with that same school exist too
    Optional<School> school = schoolRepo.findByPublicId(schoolRequest.getPublicId());
    if (school.isPresent())
      throw new ResourceNotFoundException("School with the same public id already exists");

    School entity = schoolMapper.toEntity(schoolRequest, user);
    entity = schoolRepo.save(entity);

    user.setSchool(entity);
    usersRepo.save(user);

    firebaseService.setCustomClaims(userId, user.getRole(), entity.getId().toString());
    return entity.getId();
  }

  public SchoolResponse updateSchool(SchoolRequest schoolRequest, UUID schoolId) {

    String userId = AuthenticationUtils.getCurrentUserId();

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
