package com.tigana.Users.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.Interfaces.RequireAuth;
import com.tigana.Users.DTO.UserPageRequest;
import com.tigana.Users.Service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService usersService;

    @GetMapping("/")
    @RequireAuth
    public String users(@ModelAttribute UserPageRequest userPageRequest) {
        return "true";
    }

}
