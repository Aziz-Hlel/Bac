package com.tigana.ClassUnit.Model;

import java.util.UUID;

import com.tigana.School.Model.School;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    private String name;

    @OneToMany
    @Column(nullable = true)
    private SchoolMajors schoolMajorsPrincipal;

    @OneToMany
    @Column(nullable = true)
    private SchoolOptionalSubjects schoolOptionalSubjectsPrincipal;

    @OneToMany
    @Column(nullable = true)
    private SchoolMajors schoolMajorsRetake;

    @OneToMany
    @Column(nullable = false, updatable = false)
    private School school;

}
