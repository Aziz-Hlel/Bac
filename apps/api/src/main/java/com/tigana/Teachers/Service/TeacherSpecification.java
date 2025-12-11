package com.tigana.Teachers.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.tigana.Enums.RoleEnums;
import com.tigana.Teachers.Model.Teacher;

import jakarta.persistence.criteria.Predicate;

public class TeacherSpecification {

    public static Specification<Teacher> filter(String search, RoleEnums role) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (search != null && !search.isBlank()) {
                String like = "%" + search.toLowerCase() + "%";

                predicates.add(cb.or(
                        cb.like(cb.lower(root.get("firstName")), like),
                        cb.like(cb.lower(root.get("lastName")), like)));
            }

            if (role != null) {
                predicates.add(cb.equal(root.get("role"), role));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
