package com.tigana.Users.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Interfaces.CurrentUser;
import com.tigana.Users.DTO.LoginWithProviderRequest;
import com.tigana.Users.DTO.UserRequest;
import com.tigana.Users.DTO.UserProfileResponse;
import com.tigana.Users.Service.AuthService;
import com.tigana.shared.Dto.SimpleApiResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
@Validated // this is responsible of validating the PathVariable and RequestParams
public class AuthController {

        private final AuthService usersService;

        private final FirebaseAuthService firebaseService;

        @PostMapping("/register")
        public UserProfileResponse register(@Valid @RequestBody UserRequest userRequest) {

                log.info("Creating user with idToken: {}", userRequest.getIdToken());

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(userRequest.getIdToken());

                var userResponse = usersService.createUser(firebaseToken);

                return userResponse;
        }

        @PostMapping("/login")
        public UserProfileResponse loginWithPassword(@Valid @RequestBody UserRequest userRequest) {

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(userRequest.getIdToken());

                var userResponse = usersService.loginWithPassword(firebaseToken);

                return userResponse;

        }

        @PostMapping("/oauth/login")
        public UserProfileResponse authenticateWithProvider(
                        @Valid @RequestBody LoginWithProviderRequest loginWithProviderRequest) {

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(loginWithProviderRequest.getIdToken());

                UserProfileResponse userResponse = usersService.authenticateWithProvider(firebaseToken);

                return userResponse;
        }

        @GetMapping("/me")
        public UserProfileResponse getCurrentUser(@CurrentUser FirebaseToken firebaseToken) {
                log.info("Fetching current user");

                var userResponse = usersService.getCurrentUser(firebaseToken);

                return userResponse;
        }

        @GetMapping("/deleteAll")
        public SimpleApiResponse deleteAllUsers() {
                log.info("Deleting all users from Firebase Auth");

                firebaseService.deleteAllUsers();

                return new SimpleApiResponse("All users deleted from Firebase Auth");
        }

}
