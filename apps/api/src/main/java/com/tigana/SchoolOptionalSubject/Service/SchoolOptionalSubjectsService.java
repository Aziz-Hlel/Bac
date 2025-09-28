package com.tigana.SchoolOptionalSubject.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsRequest;
import com.tigana.SchoolOptionalSubject.DTO.SchoolOptionalSubjectsResponse;
import com.tigana.SchoolOptionalSubject.Mapper.SchoolOptionalSubjectsMapper;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjectsId;
import com.tigana.SchoolOptionalSubject.Repo.SchoolOptionalSubjectsRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SchoolOptionalSubjectsService {

    private final SchoolOptionalSubjectsRepo schoolOptionalSubjectsRepo;
    private final SchoolOptionalSubjectsMapper schoolOptionalSubjectsMapper;

    public List<SchoolOptionalSubjects> createSchoolOptionalSubjects(List<SchoolOptionalSubjectsRequest> bulkRequest,
            UUID schoolId) {

        List<SchoolOptionalSubjects> entites = schoolOptionalSubjectsMapper.toEntities(bulkRequest,
                schoolId);

        List<SchoolOptionalSubjects> savedEntites = schoolOptionalSubjectsRepo.saveAll(entites);

        return savedEntites;

    };

    public List<SchoolOptionalSubjects> updatedSchoolOptionalSubjects(List<SchoolOptionalSubjectsRequest> bulkRequest,
            UUID schoolId) {

        List<SchoolOptionalSubjects> entity = schoolOptionalSubjectsMapper.toEntities(bulkRequest, schoolId);

        List<SchoolOptionalSubjects> savedEntites = schoolOptionalSubjectsRepo.saveAll(entity);

        return savedEntites;
    }

    public List<SchoolOptionalSubjectsResponse> getSchoolOptionalSubjects(UUID schoolId) {

        List<SchoolOptionalSubjects> entities = schoolOptionalSubjectsRepo
                .findAllBySchoolOptionalSubjectsId_SchoolId(schoolId);
        List<SchoolOptionalSubjectsResponse> responses = schoolOptionalSubjectsMapper.toResponses(entities);
        return responses;
    }

    public SchoolOptionalSubjects getSchoolOptionalSubject(SchoolOptionalSubjectsId id) {
        SchoolOptionalSubjects entity = schoolOptionalSubjectsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SchoolOptionalSubjects not found"));

        return entity;
    }

}
