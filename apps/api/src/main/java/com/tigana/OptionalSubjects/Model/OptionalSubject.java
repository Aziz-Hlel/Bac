package com.tigana.OptionalSubjects.Model;

import java.time.LocalDate;
import java.util.UUID;

import com.tigana.Enums.OptionalSujectEnums;
import com.tigana.Enums.TermEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "optional_exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionalSubject {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OptionalSujectEnums subject;

    @Column(nullable = false)
    private Float duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermEnums term;

    @Column(nullable = false)
    private LocalDate date;

}
