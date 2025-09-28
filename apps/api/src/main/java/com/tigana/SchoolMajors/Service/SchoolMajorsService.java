package com.tigana.SchoolMajors.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.SchoolMajors.DTO.SchoolMajorsRequest;
import com.tigana.SchoolMajors.DTO.SchoolMajorsResponse;
import com.tigana.SchoolMajors.Mapper.SchoolMajorsMapper;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolMajors.Model.SchoolMajorsId;
import com.tigana.SchoolMajors.Repo.SchoolMajorsRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SchoolMajorsService {

    private final SchoolMajorsRepo schoolMajorsRepo;
    private final SchoolMajorsMapper schoolMajorsMapper;

    // ! you return boolean for both the create and update
    public List<SchoolMajors> createSchoolMajors(List<SchoolMajorsRequest> request, UUID schoolId) {

        List<SchoolMajors> toEntities = schoolMajorsMapper.toEntities(request, schoolId);
        List<SchoolMajors> savedEntities = schoolMajorsRepo.saveAll(toEntities);

        return savedEntities;
    }

    public List<SchoolMajors> updatedSchoolMajors(List<SchoolMajorsRequest> request, UUID schoolId) {

        List<SchoolMajors> toEntities = schoolMajorsMapper.toEntities(request, schoolId);
        List<SchoolMajors> savedEntities = schoolMajorsRepo.saveAll(toEntities);

        return savedEntities;

    }

    public List<SchoolMajorsResponse> getSchoolMajors(UUID schoolId) {

        List<SchoolMajors> entities = schoolMajorsRepo.findAllBySchoolMajorsId_schoolId(schoolId);

        List<SchoolMajorsResponse> responses = schoolMajorsMapper.toResponses(entities);

        return responses;

    }

    public SchoolMajors getSchoolMajor(SchoolMajorsId schoolMajorsId) {
        SchoolMajors schoolMajors = schoolMajorsRepo.findById(schoolMajorsId)
                .orElseThrow(() -> new IllegalArgumentException("SchoolMajorsId not found"));

        return schoolMajors;

    }

}
