package com.tigana.ClassUnit.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tigana.ClassUnit.DTO.BulkUpdateClassUnit;
import com.tigana.ClassUnit.DTO.ClassUnitRequest;
import com.tigana.ClassUnit.DTO.ClassUnitResponse;
import com.tigana.ClassUnit.Mapper.ClassUnitMapper;
import com.tigana.ClassUnit.Model.ClassUnit;
import com.tigana.ClassUnit.Repo.ClassUnitRepo;
import com.tigana.Enums.TermEnums;
import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.School.Model.School;
import com.tigana.School.Service.SchoolService;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolMajors.Model.SchoolMajorsId;
import com.tigana.SchoolMajors.Service.SchoolMajorsService;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjectsId;
import com.tigana.SchoolOptionalSubject.Service.SchoolOptionalSubjectsService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassUnitService {

    private final ClassUnitRepo classUnitRepo;
    private final ClassUnitMapper classUnitMapper;

    private final SchoolService schoolService;
    private final SchoolMajorsService schoolMajorsService;
    private final SchoolOptionalSubjectsService schoolOptionalSubjectsService;

    ClassUnit toEntity(ClassUnitRequest request, UUID userId, UUID schoolId) {

        SchoolMajors principalSchoolMajors = null;
        if (request.getPrincipalMajorName() != null) {
            SchoolMajorsId principalSchoolMajorsId = new SchoolMajorsId(schoolId, TermEnums.PRINCIPAL,
                    request.getPrincipalMajorName());

            principalSchoolMajors = schoolMajorsService.getSchoolMajor(principalSchoolMajorsId);

        }

        SchoolMajors retakeSchoolMajors = null;
        if (request.getRetakeMajorName() != null) {

            SchoolMajorsId retakeSchoolMajorsId = new SchoolMajorsId(schoolId, TermEnums.RETAKE,
                    request.getRetakeMajorName());

            retakeSchoolMajors = schoolMajorsService.getSchoolMajor(retakeSchoolMajorsId);
        }

        SchoolOptionalSubjects principalOptionalSubjects = null;
        if (request.getPrincipalOptionalSubject() != null) {
            SchoolOptionalSubjectsId optionalSubjectsId = new SchoolOptionalSubjectsId(schoolId, TermEnums.PRINCIPAL,
                    request.getPrincipalOptionalSubject());

            principalOptionalSubjects = schoolOptionalSubjectsService.getSchoolOptionalSubject(optionalSubjectsId);
        }

        School school = schoolService.getSchoolEntity(schoolId, userId);

        ClassUnit entity = ClassUnit.builder()
                .name(request.getName())
                .schoolMajorsPrincipal(principalSchoolMajors)
                .schoolMajorsRetake(retakeSchoolMajors)
                .schoolOptionalSubjectsPrincipal(principalOptionalSubjects)
                .school(school)
                .build();

        return entity;
    }

    public void createClassUnit(ClassUnitRequest request, UUID userId, UUID schoolId) {

        ClassUnit entity = toEntity(request, userId, schoolId);

        classUnitRepo.save(entity);

    }

    public void updateClassUnit(ClassUnitRequest request, UUID classUnitId) {

        ClassUnit entity = classUnitRepo.findById(classUnitId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassUnit not found"));

        ClassUnit updatedEntity = toEntity(request, entity.getSchool().getUser().getId(), entity.getSchool().getId());

        classUnitRepo.save(updatedEntity);

    }

    public void bulkUpdateClassUnitByMajorsAndTerms(BulkUpdateClassUnit request, UUID userId, UUID schoolId) {
        // ? lazy implementation
        List<ClassUnit> classUnits = request.getClassUnits().stream()
                .map(classUnitRequest -> toEntity(classUnitRequest, userId, schoolId)).toList();

        classUnitRepo.saveAll(classUnits);
    };

    public ClassUnitResponse getClassUnit(UUID classUnitId, UUID userId) {
        // maybe add a condition to check if user ows the classUnit before gettin it

        ClassUnit classUnit = classUnitRepo.findById(classUnitId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassUnit not found"));

        ClassUnitResponse response = classUnitMapper.toResponse(classUnit);

        return response;
    }

    public List<ClassUnitResponse> bulkGetClassUnit(UUID schoolId, UUID userId) {

        School school = schoolService.getSchoolEntity(schoolId, userId);

        List<ClassUnit> classUnits = classUnitRepo.findAllBySchool(school);

        List<ClassUnitResponse> response = classUnits.stream().map(classUnitMapper::toResponse).toList();

        return response;

    };


}
