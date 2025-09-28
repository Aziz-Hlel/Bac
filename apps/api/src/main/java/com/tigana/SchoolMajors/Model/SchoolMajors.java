package com.tigana.SchoolMajors.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school_majors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolMajors {

    @EmbeddedId
    private SchoolMajorsId schoolMajorsId;

    
    @Column(nullable = false)
    private int classNumber;



}