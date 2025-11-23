package com.tigana.ClassUnit.Model;

import java.util.UUID;

import com.tigana.School.Model.School;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "class", uniqueConstraints = {
                @UniqueConstraint(name = "class_unique_name_per_school", columnNames = { "name", "school_id" }) })
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

        @Column(name = "name", nullable = false)
        private String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "school_id", nullable = false, updatable = false)
        private School school;

}
