package com.tigana.ClassUnit.Model;

import java.util.UUID;

import com.tigana.School.Model.School;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "class")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassUnit {
    // add a unique constraint on name and school , each school can have a unique
    // class with unique name
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "principal_major_school_id", referencedColumnName = "schoolId"),
            @JoinColumn(name = "principal_major_term", referencedColumnName = "term"),
            @JoinColumn(name = "principal_major_name", referencedColumnName = "majorName")
    })
    private SchoolMajors schoolMajorsPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "principal_optional_school_id", referencedColumnName = "schoolId"),
            @JoinColumn(name = "principal_optional_term", referencedColumnName = "term"),
            @JoinColumn(name = "principal_optional_subject", referencedColumnName = "optionalSubject")
    })
    private SchoolOptionalSubjects schoolOptionalSubjectsPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "retake_major_school_id", referencedColumnName = "schoolId"),
            @JoinColumn(name = "retake_major_term", referencedColumnName = "term"),
            @JoinColumn(name = "retake_major_name", referencedColumnName = "majorName")
    })
    private SchoolMajors schoolMajorsRetake;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false, updatable = false)
    private School school;

}
