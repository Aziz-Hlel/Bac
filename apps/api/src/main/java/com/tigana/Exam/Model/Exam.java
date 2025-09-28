package com.tigana.Exam.Model;

import java.time.LocalDate;
import java.util.UUID;

import com.tigana.Enums.MajorEnums;
import com.tigana.Enums.SessionEnums;
import com.tigana.Enums.SubjectEnums;
import com.tigana.Enums.TermEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Enumerated(EnumType.STRING) // so values are stored as readable strings in the DB.
    @Column(nullable = false)
    private MajorEnums major;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubjectEnums subject;

    @Column(nullable = false)
    private SessionEnums seesion;

    @Column(nullable = false)
    private float duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermEnums term;

    @Column(nullable = false)
    private LocalDate date;

}
