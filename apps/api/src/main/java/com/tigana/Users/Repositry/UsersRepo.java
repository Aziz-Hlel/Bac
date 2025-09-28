package com.tigana.Users.Repositry;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tigana.Users.Entity.User;


@Repository
public interface UsersRepo extends JpaRepository<User, UUID> {

}
