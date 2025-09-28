package com.tigana.Users.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tigana.Users.DTO.UserRequest;
import com.tigana.Users.Entity.User;
import com.tigana.Users.Mapper.UserMapper;
import com.tigana.Users.Repositry.UsersRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepo usersRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserRequest userRequest) {

        User userEntity = userMapper.toEntity(userRequest);

        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return usersRepo.save(userEntity);
    }

}
