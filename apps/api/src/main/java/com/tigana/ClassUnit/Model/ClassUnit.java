package com.tigana.ClassUnit.Model;

import java.util.UUID;

import com.tigana.School.Model.School;
import com.tigana.SchoolMajors.Model.SchoolMajors;
import com.tigana.SchoolOptionalSubject.Model.SchoolOptionalSubjects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    // add a unique constraint on name and school , each school can have a unique
    // class with unique name
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

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false, updatable = false)
    private School school;

}
