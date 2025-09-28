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

    @EmbeddedId
    private SchoolOptionalSubjectsId schoolOptionalSubjectsId;

    @Column(nullable = false)
    private int classNumber;
}
