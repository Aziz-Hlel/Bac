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
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam", uniqueConstraints = {
        @UniqueConstraint(name = "uk_major_subject_session_term", columnNames = { "major", "subject", "session",
                "term" })

}, indexes = {
        @Index(name = "idx_exam_subject", columnList = "subject")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    // Tablo t3 les roznemet les examens en general , since les examens kol
    // yet3addew fard w9t f touns l kol
    // donc l superadmin(me) set them up once each year
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "major", nullable = true)
    private MajorEnums major;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject", nullable = false)
    private SubjectEnums subject;

    @Column(name = "session", nullable = false)
    private SessionEnums session;

    @Column(name = "duration", nullable = false)
    private float duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "term", nullable = false)
    private TermEnums term;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}