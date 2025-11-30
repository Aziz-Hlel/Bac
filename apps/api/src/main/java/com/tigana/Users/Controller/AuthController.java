package com.tigana.Users.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Users.DTO.LoginWithProviderRequest;
import com.tigana.Users.DTO.UserRequest;
import com.tigana.Users.DTO.UserProfileResponse;
import com.tigana.Users.Service.AuthService;
import com.tigana.Utils.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;
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
        public ResponseEntity<ApiResponse<UserProfileResponse>> register(@Valid @RequestBody UserRequest userRequest) {

                log.info("Creating user with idToken: {}", userRequest.getIdToken());

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(userRequest.getIdToken());

                var userResponse = usersService.createUser(firebaseToken);

                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(ApiResponse.<UserProfileResponse>builder()
                                                .message("User created successfully")
                                                .data(userResponse)
                                                .status(HttpStatus.CREATED)
                                                .build());

        }

        @PostMapping("/login")
        public ResponseEntity<ApiResponse<UserProfileResponse>> login(@Valid @RequestBody UserRequest userRequest) {

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(userRequest.getIdToken());

                var userResponse = usersService.login(firebaseToken);

                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.<UserProfileResponse>builder()
                                                .message("User logged in successfully")
                                                .data(userResponse)
                                                .status(HttpStatus.OK)
                                                .build());

        }

        @PostMapping("/oauth/login")
        public ResponseEntity<ApiResponse<UserProfileResponse>> authenticateWithProvider(
                        @Valid @RequestBody LoginWithProviderRequest loginWithProviderRequest) {

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(loginWithProviderRequest.getIdToken());

                UserProfileResponse userResponse = usersService.authenticateWithProvider(firebaseToken);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.<UserProfileResponse>builder()
                                                .message("User authenticated successfully with external provider")
                                                .data(userResponse)
                                                .status(HttpStatus.OK)
                                                .build());
        }

        @GetMapping("/me")
        public ResponseEntity<ApiResponse<UserProfileResponse>> getCurrentUser(HttpServletRequest request) {
                log.info("Fetching current user");

                String idToken = request.getHeader("Authorization").substring(7);

                FirebaseToken firebaseToken = firebaseService.verifyIdToken(idToken);

                var userResponse = usersService.getCurrentUser(firebaseToken);

                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.<UserProfileResponse>builder()
                                                .message("Current user fetched successfully")
                                                .data(userResponse)
                                                .status(HttpStatus.OK)
                                                .build());
        }

        @GetMapping("/deleteAll")
        public ResponseEntity<ApiResponse<String>> deleteAllUsers() {
                log.info("Deleting all users from Firebase Auth");

                firebaseService.deleteAllUsers();

                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.<String>builder()
                                                .message("All users deleted successfully from Firebase Auth")
                                                .data("All users deleted")
                                                .build());
        }

}
