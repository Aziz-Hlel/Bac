package com.tigana.SchoolOptionalSubject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "school_optional_classes")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolOptionalSubjects {

    // this table is to specify how many classes are reserved for each optional
    // subject, look into the the Term field, i think it's useless cuz you can't
    // retake any optional subject
    @EmbeddedId
    private SchoolOptionalSubjectsId schoolOptionalSubjectsId;

    @Column(nullable = false)
    private int classNumber;
}
