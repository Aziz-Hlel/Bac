package com.tigana.SchoolMajors.Model;

import java.io.Serializable;
import java.util.UUID;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.TermEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolMajorsId implements Serializable {

    @Column(nullable = false)
    private UUID schoolId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermEnums term;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MajorEnums majorName;
};
