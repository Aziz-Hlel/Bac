package com.tigana.Users.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Users.DTO.UserRequest;
import com.tigana.Users.DTO.UserResponse;
import com.tigana.Users.Model.User;
import com.tigana.Users.Service.UserService;
import com.tigana.Utils.ApiResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
@Validated // this is responsible of validating the PathVariable and RequestParams
public class UserController {

    private final UserService usersService;

    private final FirebaseAuthService firebaseService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody UserRequest userRequest) {

        log.info("Creating user with tokenId: {}", userRequest.getTokenId());

        FirebaseToken firebaseToken = firebaseService.verifyIdToken(userRequest.getTokenId());

        var userResponse = usersService.createUser(firebaseToken);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User created successfully")
                        .data(userResponse)
                        .status(HttpStatus.CREATED)
                        .build());

    }

}
