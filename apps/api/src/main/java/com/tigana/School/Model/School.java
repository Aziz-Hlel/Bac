package com.tigana.School.Model;

import java.util.UUID;

import com.tigana.Enums.CityEnums;
import com.tigana.Users.Entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    private String publicId;

    private String name;

    private CityEnums city;

    private String address;

    @OneToOne(mappedBy = "school", fetch = FetchType.LAZY, optional = false)
    private User user;

}
 