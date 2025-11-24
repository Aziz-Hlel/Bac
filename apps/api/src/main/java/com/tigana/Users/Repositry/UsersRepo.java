package com.tigana.Users.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.tigana.Users.Model.User;

@Repository
public interface UsersRepo extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
