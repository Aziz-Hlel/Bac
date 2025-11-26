package com.tigana.Users.Model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.tigana.Enums.RoleEnums;
import com.tigana.School.Model.School;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User { // implements UserDetails {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "sign_in_provider", nullable = true)
    private String signInProvider;

    // @Column(nullable = false)
    // private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleEnums role;

    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL) // added cascade = CascadeType.ALL for
    // the seeder
    @JoinColumn(name = "school_id", unique = true, nullable = true)
    private School school;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    // return Collections.singleton(new SimpleGrantedAuthority("ROLE_" +
    // getRole().name()));
    // }

    // @Override
    // public String getPassword() {
    // return "password"; // ! Removed password field to integrate firebase auth
    // }

    // @Override
    // public String getUsername() {
    // return username;
    // }

}
