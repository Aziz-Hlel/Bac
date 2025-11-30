package com.tigana.Seeders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.Enums.RoleEnums;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Component
public class SeedUser {

    private final UsersRepo usersRepo;

    public void seed() {

        List<User> usersToSeed = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {

            String seedEmail = "user" + i + "@example.com";
            String seedUsername = "user" + i;
            String seedId = "user" + i;
            User user = User.builder()
                    .id(seedId)
                    .email(seedEmail)
                    .username(seedUsername)
                    .role(RoleEnums.ADMIN)
                    .build();
            Optional<User> existingUser = usersRepo.findByEmail(user.getEmail());
            if (existingUser.isEmpty()) {
                usersToSeed.add(user);
            }
        }
        usersRepo.saveAll(usersToSeed);
        log.info("Seeded users.");

    }
}