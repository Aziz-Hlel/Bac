package com.tigana.Seeders;

import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.tigana.Enums.RoleEnums;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProdSeeder {

    private final UsersRepo usersRepo;
    private final FirebaseAuthService firebaseAuthService;

    public void seed() {
        // Add production seeding logic here
        log.info("Production seeding completed.");

        String godEmail = "m.aziz.hlel@gmail.com";
        String godUsername = "tigana";

        UserRecord godFirebaseAccount = firebaseAuthService.getUserByEmail(godEmail);
        String godUid = null;
        if (godFirebaseAccount != null) {
            godUid = godFirebaseAccount.getUid();
        } else {
            try {
                firebaseAuthService.createUser(godEmail, "12345678");
                godFirebaseAccount = firebaseAuthService.getUserByEmail(godEmail);
                godUid = godFirebaseAccount.getUid();
            } catch (FirebaseAuthException e) {
                throw new RuntimeException("Failed to create Main Super Admin user in Firebase");
            }
        }

        if (usersRepo.findByEmail(godEmail).isEmpty()) {
            usersRepo.save(User.builder()
                    .id(godUid)
                    .email(godEmail)
                    .username(godUsername)
                    .role(RoleEnums.SUPER_ADMIN)
                    .build());
            log.info("God user created.");
        } else {
            log.info("God user already exists.");
        }
    }
}
