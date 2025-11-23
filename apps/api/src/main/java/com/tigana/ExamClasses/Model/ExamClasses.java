package com.tigana.ExamClasses.Model;

import java.util.UUID;

import com.tigana.ClassUnit.Model.ClassUnit;
import com.tigana.Exam.Model.Exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam_classes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamClasses {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassUnit classUnit;
}
