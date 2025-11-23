package com.tigana.Users.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Enums.RoleEnums;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Users.Mapper.UserMapper;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepo usersRepo;
    private final UserMapper userMapper;
    private final FirebaseAuthService firebaseService;

    public User createUser(FirebaseToken firebaseToken) {

        if (usersRepo.existsByEmail(firebaseToken.getEmail())) {
            throw new IllegalArgumentException("User with email " + firebaseToken.getEmail() + " already exists.");
        }

        UUID userId = UUID.fromString(firebaseToken.getUid());

        User userEntity = User.builder()
                .id(userId)
                .username(firebaseToken.getName())
                .email(firebaseToken.getEmail())
                .role(RoleEnums.ADMIN)
                .build();

        // User userEntity = userMapper.toEntity(userRequest);

        // userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User savedUser = usersRepo.save(userEntity);

        firebaseService.setCustomClaims(userId.toString(), savedUser.getRole(), null);

        return savedUser;
    }

}
